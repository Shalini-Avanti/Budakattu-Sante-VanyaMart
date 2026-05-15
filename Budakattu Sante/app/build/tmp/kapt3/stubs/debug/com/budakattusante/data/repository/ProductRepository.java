package com.budakattusante.data.repository;

import com.budakattusante.data.db.dao.ProductDao;
import com.budakattusante.data.db.dao.TribalFamilyDao;
import com.budakattusante.data.db.entity.Product;
import com.budakattusante.data.db.entity.TribalFamily;
import kotlinx.coroutines.flow.Flow;
import javax.inject.Inject;
import javax.inject.Singleton;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0086@\u00a2\u0006\u0002\u0010\u000bJ\u0012\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u000e0\rJ\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0086@\u00a2\u0006\u0002\u0010\u0013J\u0012\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u000e0\rJ\u0018\u0010\u0015\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0011\u001a\u00020\u0012H\u0086@\u00a2\u0006\u0002\u0010\u0013J\u000e\u0010\u0016\u001a\u00020\u0012H\u0086@\u00a2\u0006\u0002\u0010\u0017J\u001a\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u000e0\r2\u0006\u0010\u0019\u001a\u00020\u001aJ\u0016\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\t\u001a\u00020\nH\u0086@\u00a2\u0006\u0002\u0010\u000bJ\u001e\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u0012H\u0086@\u00a2\u0006\u0002\u0010 J\u001a\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u000e0\r2\u0006\u0010\"\u001a\u00020\u001aJ\u0016\u0010#\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0086@\u00a2\u0006\u0002\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006$"}, d2 = {"Lcom/budakattusante/data/repository/ProductRepository;", "", "productDao", "Lcom/budakattusante/data/db/dao/ProductDao;", "tribalFamilyDao", "Lcom/budakattusante/data/db/dao/TribalFamilyDao;", "(Lcom/budakattusante/data/db/dao/ProductDao;Lcom/budakattusante/data/db/dao/TribalFamilyDao;)V", "deleteProduct", "", "product", "Lcom/budakattusante/data/db/entity/Product;", "(Lcom/budakattusante/data/db/entity/Product;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllProducts", "Lkotlinx/coroutines/flow/Flow;", "", "getFamilyById", "Lcom/budakattusante/data/db/entity/TribalFamily;", "id", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLowStockProducts", "getProductById", "getProductCount", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getProductsByCategory", "category", "", "insertProduct", "", "reduceStock", "productId", "quantity", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "searchProducts", "query", "updateProduct", "app_debug"})
public final class ProductRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.budakattusante.data.db.dao.ProductDao productDao = null;
    @org.jetbrains.annotations.NotNull()
    private final com.budakattusante.data.db.dao.TribalFamilyDao tribalFamilyDao = null;
    
    @javax.inject.Inject()
    public ProductRepository(@org.jetbrains.annotations.NotNull()
    com.budakattusante.data.db.dao.ProductDao productDao, @org.jetbrains.annotations.NotNull()
    com.budakattusante.data.db.dao.TribalFamilyDao tribalFamilyDao) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.budakattusante.data.db.entity.Product>> getAllProducts() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.budakattusante.data.db.entity.Product>> getProductsByCategory(@org.jetbrains.annotations.NotNull()
    java.lang.String category) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.budakattusante.data.db.entity.Product>> searchProducts(@org.jetbrains.annotations.NotNull()
    java.lang.String query) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.budakattusante.data.db.entity.Product>> getLowStockProducts() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getProductById(int id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.budakattusante.data.db.entity.Product> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object insertProduct(@org.jetbrains.annotations.NotNull()
    com.budakattusante.data.db.entity.Product product, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object updateProduct(@org.jetbrains.annotations.NotNull()
    com.budakattusante.data.db.entity.Product product, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object deleteProduct(@org.jetbrains.annotations.NotNull()
    com.budakattusante.data.db.entity.Product product, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object reduceStock(int productId, int quantity, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getProductCount(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getFamilyById(int id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.budakattusante.data.db.entity.TribalFamily> $completion) {
        return null;
    }
}