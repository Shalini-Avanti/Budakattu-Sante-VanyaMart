package com.budakattusante.data.db.dao

import androidx.room.*
import com.budakattusante.data.db.entity.Order
import kotlinx.coroutines.flow.Flow

@Dao
interface OrderDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrder(order: Order): Long

    @Query("SELECT * FROM orders WHERE buyerId = :buyerId ORDER BY orderDate DESC")
    fun getOrdersByBuyer(buyerId: Int): Flow<List<Order>>

    @Query("SELECT * FROM orders ORDER BY orderDate DESC LIMIT 20")
    fun getAllOrders(): Flow<List<Order>>

    @Query("SELECT COUNT(*) FROM orders")
    suspend fun getOrderCount(): Int

    @Query("SELECT COALESCE(SUM(totalAmount), 0.0) FROM orders")
    suspend fun getTotalEarnings(): Double
}
