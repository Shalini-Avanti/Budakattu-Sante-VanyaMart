package com.budakattusante.data.repository

import com.budakattusante.data.db.dao.OrderDao
import com.budakattusante.data.db.entity.Order
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class OrderRepository @Inject constructor(private val orderDao: OrderDao) {

    fun getOrdersByBuyer(buyerId: Int): Flow<List<Order>> = orderDao.getOrdersByBuyer(buyerId)

    fun getAllOrders(): Flow<List<Order>> = orderDao.getAllOrders()

    suspend fun insertOrder(order: Order): Long = orderDao.insertOrder(order)

    suspend fun getOrderCount(): Int = orderDao.getOrderCount()

    suspend fun getTotalEarnings(): Double = orderDao.getTotalEarnings()
}
