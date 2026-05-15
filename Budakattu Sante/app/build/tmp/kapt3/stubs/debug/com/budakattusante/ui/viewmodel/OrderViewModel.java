package com.budakattusante.ui.viewmodel;

import androidx.lifecycle.*;
import com.budakattusante.data.db.entity.Order;
import com.budakattusante.data.repository.OrderRepository;
import com.budakattusante.data.repository.ProductRepository;
import dagger.hilt.android.lifecycle.HiltViewModel;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010!\u001a\u00020\"J\u000e\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\fJ6\u0010%\u001a\u00020\"2\u0006\u0010&\u001a\u00020\f2\u0006\u0010$\u001a\u00020\f2\u0006\u0010\'\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020\f2\u0006\u0010)\u001a\u00020\u00122\u0006\u0010*\u001a\u00020\fR\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\f0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001d\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\f0\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\f0\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00120\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u0016\u00a8\u0006+"}, d2 = {"Lcom/budakattusante/ui/viewmodel/OrderViewModel;", "Landroidx/lifecycle/ViewModel;", "orderRepository", "Lcom/budakattusante/data/repository/OrderRepository;", "productRepository", "Lcom/budakattusante/data/repository/ProductRepository;", "(Lcom/budakattusante/data/repository/OrderRepository;Lcom/budakattusante/data/repository/ProductRepository;)V", "_buyerOrders", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/budakattusante/data/db/entity/Order;", "_orderCount", "", "_orderResult", "Lkotlin/Result;", "", "_productCount", "_totalEarnings", "", "allOrders", "Landroidx/lifecycle/LiveData;", "getAllOrders", "()Landroidx/lifecycle/LiveData;", "buyerOrders", "getBuyerOrders", "orderCount", "getOrderCount", "orderResult", "getOrderResult", "productCount", "getProductCount", "totalEarnings", "getTotalEarnings", "loadAnalytics", "", "loadBuyerOrders", "buyerId", "placeOrder", "productId", "productName", "quantity", "pricePerUnit", "availableStock", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class OrderViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.budakattusante.data.repository.OrderRepository orderRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.budakattusante.data.repository.ProductRepository productRepository = null;
    
    /**
     * All orders (for leader dashboard)
     */
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.budakattusante.data.db.entity.Order>> allOrders = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.budakattusante.data.db.entity.Order>> _buyerOrders = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.budakattusante.data.db.entity.Order>> buyerOrders = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<kotlin.Result<java.lang.String>> _orderResult = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<kotlin.Result<java.lang.String>> orderResult = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Double> _totalEarnings = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.Double> totalEarnings = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Integer> _orderCount = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.Integer> orderCount = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Integer> _productCount = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.Integer> productCount = null;
    
    @javax.inject.Inject()
    public OrderViewModel(@org.jetbrains.annotations.NotNull()
    com.budakattusante.data.repository.OrderRepository orderRepository, @org.jetbrains.annotations.NotNull()
    com.budakattusante.data.repository.ProductRepository productRepository) {
        super();
    }
    
    /**
     * All orders (for leader dashboard)
     */
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.budakattusante.data.db.entity.Order>> getAllOrders() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.budakattusante.data.db.entity.Order>> getBuyerOrders() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<kotlin.Result<java.lang.String>> getOrderResult() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Double> getTotalEarnings() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Integer> getOrderCount() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Integer> getProductCount() {
        return null;
    }
    
    /**
     * Load orders for a specific buyer
     */
    public final void loadBuyerOrders(int buyerId) {
    }
    
    /**
     * Place a preorder. Validates stock before confirming.
     * If successful, reduces product stock automatically.
     */
    public final void placeOrder(int productId, int buyerId, @org.jetbrains.annotations.NotNull()
    java.lang.String productName, int quantity, double pricePerUnit, int availableStock) {
    }
    
    /**
     * Load analytics data for leader dashboard
     */
    public final void loadAnalytics() {
    }
}