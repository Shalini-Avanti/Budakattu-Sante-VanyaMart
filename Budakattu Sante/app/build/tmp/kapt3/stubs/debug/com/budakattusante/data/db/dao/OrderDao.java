package com.budakattusante.data.db.dao;

import androidx.room.*;
import com.budakattusante.data.db.entity.Order;
import kotlinx.coroutines.flow.Flow;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H\'J\u000e\u0010\u0006\u001a\u00020\u0007H\u00a7@\u00a2\u0006\u0002\u0010\bJ\u001c\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\n\u001a\u00020\u0007H\'J\u000e\u0010\u000b\u001a\u00020\fH\u00a7@\u00a2\u0006\u0002\u0010\bJ\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0010\u00a8\u0006\u0011"}, d2 = {"Lcom/budakattusante/data/db/dao/OrderDao;", "", "getAllOrders", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/budakattusante/data/db/entity/Order;", "getOrderCount", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getOrdersByBuyer", "buyerId", "getTotalEarnings", "", "insertOrder", "", "order", "(Lcom/budakattusante/data/db/entity/Order;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
@androidx.room.Dao()
public abstract interface OrderDao {
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertOrder(@org.jetbrains.annotations.NotNull()
    com.budakattusante.data.db.entity.Order order, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM orders WHERE buyerId = :buyerId ORDER BY orderDate DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.budakattusante.data.db.entity.Order>> getOrdersByBuyer(int buyerId);
    
    @androidx.room.Query(value = "SELECT * FROM orders ORDER BY orderDate DESC LIMIT 20")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.budakattusante.data.db.entity.Order>> getAllOrders();
    
    @androidx.room.Query(value = "SELECT COUNT(*) FROM orders")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getOrderCount(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion);
    
    @androidx.room.Query(value = "SELECT COALESCE(SUM(totalAmount), 0.0) FROM orders")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getTotalEarnings(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Double> $completion);
}