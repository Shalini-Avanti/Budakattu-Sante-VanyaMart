package com.budakattusante.ui.viewmodel;

import androidx.lifecycle.*;
import com.budakattusante.data.db.entity.Product;
import com.budakattusante.data.db.entity.TribalFamily;
import com.budakattusante.data.repository.ProductRepository;
import dagger.hilt.android.lifecycle.HiltViewModel;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\bJ\u000e\u0010\u001f\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\bJ\u000e\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\nJ\u000e\u0010\"\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020$J\u000e\u0010%\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020\nJ\u0006\u0010\'\u001a\u00020\u001dJ\u000e\u0010(\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\bR\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u001d\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\n0\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011R\u0019\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0011\u00a8\u0006)"}, d2 = {"Lcom/budakattusante/ui/viewmodel/ProductViewModel;", "Landroidx/lifecycle/ViewModel;", "productRepository", "Lcom/budakattusante/data/repository/ProductRepository;", "(Lcom/budakattusante/data/repository/ProductRepository;)V", "_filteredProducts", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/budakattusante/data/db/entity/Product;", "_operationResult", "", "_selectedFamily", "Lcom/budakattusante/data/db/entity/TribalFamily;", "_selectedProduct", "allProducts", "Landroidx/lifecycle/LiveData;", "getAllProducts", "()Landroidx/lifecycle/LiveData;", "filteredProducts", "getFilteredProducts", "lowStockProducts", "getLowStockProducts", "operationResult", "getOperationResult", "selectedFamily", "getSelectedFamily", "selectedProduct", "getSelectedProduct", "addProduct", "", "product", "deleteProduct", "filterByCategory", "category", "loadProductById", "id", "", "searchProducts", "query", "showAll", "updateProduct", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class ProductViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.budakattusante.data.repository.ProductRepository productRepository = null;
    
    /**
     * All products from DB, observed as LiveData
     */
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.budakattusante.data.db.entity.Product>> allProducts = null;
    
    /**
     * Products with stock < 10
     */
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.budakattusante.data.db.entity.Product>> lowStockProducts = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.budakattusante.data.db.entity.Product> _selectedProduct = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<com.budakattusante.data.db.entity.Product> selectedProduct = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.budakattusante.data.db.entity.TribalFamily> _selectedFamily = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<com.budakattusante.data.db.entity.TribalFamily> selectedFamily = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.budakattusante.data.db.entity.Product>> _filteredProducts = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.budakattusante.data.db.entity.Product>> filteredProducts = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.String> _operationResult = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.String> operationResult = null;
    
    @javax.inject.Inject()
    public ProductViewModel(@org.jetbrains.annotations.NotNull()
    com.budakattusante.data.repository.ProductRepository productRepository) {
        super();
    }
    
    /**
     * All products from DB, observed as LiveData
     */
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.budakattusante.data.db.entity.Product>> getAllProducts() {
        return null;
    }
    
    /**
     * Products with stock < 10
     */
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.budakattusante.data.db.entity.Product>> getLowStockProducts() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.budakattusante.data.db.entity.Product> getSelectedProduct() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.budakattusante.data.db.entity.TribalFamily> getSelectedFamily() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.budakattusante.data.db.entity.Product>> getFilteredProducts() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.String> getOperationResult() {
        return null;
    }
    
    /**
     * Load a single product by ID
     */
    public final void loadProductById(int id) {
    }
    
    /**
     * Filter products by category
     */
    public final void filterByCategory(@org.jetbrains.annotations.NotNull()
    java.lang.String category) {
    }
    
    /**
     * Search products by name or village
     */
    public final void searchProducts(@org.jetbrains.annotations.NotNull()
    java.lang.String query) {
    }
    
    /**
     * Show all products (reset filter)
     */
    public final void showAll() {
    }
    
    /**
     * Add a new product (used by leader)
     */
    public final void addProduct(@org.jetbrains.annotations.NotNull()
    com.budakattusante.data.db.entity.Product product) {
    }
    
    /**
     * Update existing product
     */
    public final void updateProduct(@org.jetbrains.annotations.NotNull()
    com.budakattusante.data.db.entity.Product product) {
    }
    
    /**
     * Delete a product
     */
    public final void deleteProduct(@org.jetbrains.annotations.NotNull()
    com.budakattusante.data.db.entity.Product product) {
    }
}