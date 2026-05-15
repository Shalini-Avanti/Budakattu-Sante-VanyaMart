package com.budakattusante.ui.viewmodel

import androidx.lifecycle.*
import com.budakattusante.data.db.entity.Product
import com.budakattusante.data.db.entity.TribalFamily
import com.budakattusante.data.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
    private val productRepository: ProductRepository
) : ViewModel() {

    /** All products from DB, observed as LiveData */
    val allProducts: LiveData<List<Product>> = productRepository.getAllProducts().asLiveData()

    /** Products with stock < 10 */
    val lowStockProducts: LiveData<List<Product>> = productRepository.getLowStockProducts().asLiveData()

    private val _selectedProduct = MutableLiveData<Product?>()
    val selectedProduct: LiveData<Product?> = _selectedProduct

    private val _selectedFamily = MutableLiveData<TribalFamily?>()
    val selectedFamily: LiveData<TribalFamily?> = _selectedFamily

    private val _filteredProducts = MutableLiveData<List<Product>>()
    val filteredProducts: LiveData<List<Product>> = _filteredProducts

    private val _operationResult = MutableLiveData<String>()
    val operationResult: LiveData<String> = _operationResult

    /** Load a single product by ID */
    fun loadProductById(id: Int) {
        viewModelScope.launch {
            val product = productRepository.getProductById(id)
            _selectedProduct.value = product
            product?.let {
                _selectedFamily.value = productRepository.getFamilyById(it.tribalFamilyId)
            }
        }
    }

    /** Filter products by category */
    fun filterByCategory(category: String) {
        viewModelScope.launch {
            productRepository.getProductsByCategory(category).collect { list ->
                _filteredProducts.value = list
            }
        }
    }

    /** Search products by name or village */
    fun searchProducts(query: String) {
        viewModelScope.launch {
            productRepository.searchProducts(query).collect { list ->
                _filteredProducts.value = list
            }
        }
    }

    /** Show all products (reset filter) */
    fun showAll() {
        viewModelScope.launch {
            productRepository.getAllProducts().collect { list ->
                _filteredProducts.value = list
            }
        }
    }

    /** Add a new product (used by leader) */
    fun addProduct(product: Product) {
        viewModelScope.launch {
            val id = productRepository.insertProduct(product)
            _operationResult.value = if (id > 0) "Product added successfully!" else "Failed to add product."
        }
    }

    /** Update existing product */
    fun updateProduct(product: Product) {
        viewModelScope.launch {
            productRepository.updateProduct(product)
            _operationResult.value = "Product updated!"
        }
    }

    /** Delete a product */
    fun deleteProduct(product: Product) {
        viewModelScope.launch {
            productRepository.deleteProduct(product)
            _operationResult.value = "Product deleted."
        }
    }
}
