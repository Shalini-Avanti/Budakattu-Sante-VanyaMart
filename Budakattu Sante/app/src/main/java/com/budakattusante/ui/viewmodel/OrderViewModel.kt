package com.budakattusante.ui.viewmodel

import androidx.lifecycle.*
import com.budakattusante.data.db.entity.Order
import com.budakattusante.data.repository.OrderRepository
import com.budakattusante.data.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OrderViewModel @Inject constructor(
    private val orderRepository: OrderRepository,
    private val productRepository: ProductRepository
) : ViewModel() {

    /** All orders (for leader dashboard) */
    val allOrders: LiveData<List<Order>> = orderRepository.getAllOrders().asLiveData()

    private val _buyerOrders = MutableLiveData<List<Order>>()
    val buyerOrders: LiveData<List<Order>> = _buyerOrders

    private val _orderResult = MutableLiveData<Result<String>>()
    val orderResult: LiveData<Result<String>> = _orderResult

    private val _totalEarnings = MutableLiveData<Double>()
    val totalEarnings: LiveData<Double> = _totalEarnings

    private val _orderCount = MutableLiveData<Int>()
    val orderCount: LiveData<Int> = _orderCount

    private val _productCount = MutableLiveData<Int>()
    val productCount: LiveData<Int> = _productCount

    /** Load orders for a specific buyer */
    fun loadBuyerOrders(buyerId: Int) {
        viewModelScope.launch {
            orderRepository.getOrdersByBuyer(buyerId).collect { orders ->
                _buyerOrders.value = orders
            }
        }
    }

    /**
     * Place a preorder. Validates stock before confirming.
     * If successful, reduces product stock automatically.
     */
    fun placeOrder(
        productId: Int,
        buyerId: Int,
        productName: String,
        quantity: Int,
        pricePerUnit: Double,
        availableStock: Int
    ) {
        viewModelScope.launch {
            if (quantity <= 0) {
                _orderResult.value = Result.failure(Exception("Quantity must be at least 1."))
                return@launch
            }
            if (quantity > availableStock) {
                _orderResult.value = Result.failure(
                    Exception("Harvest Limit Reached! Only $availableStock units available.")
                )
                return@launch
            }
            val order = Order(
                productId = productId,
                buyerId = buyerId,
                productName = productName,
                quantity = quantity,
                totalAmount = quantity * pricePerUnit,
                status = "Confirmed"
            )
            val id = orderRepository.insertOrder(order)
            if (id > 0) {
                productRepository.reduceStock(productId, quantity)
                _orderResult.value = Result.success("Order confirmed for $productName!")
            } else {
                _orderResult.value = Result.failure(Exception("Order failed. Please try again."))
            }
        }
    }

    /** Load analytics data for leader dashboard */
    fun loadAnalytics() {
        viewModelScope.launch {
            _totalEarnings.value = orderRepository.getTotalEarnings()
            _orderCount.value = orderRepository.getOrderCount()
            _productCount.value = productRepository.getProductCount()
        }
    }
}
