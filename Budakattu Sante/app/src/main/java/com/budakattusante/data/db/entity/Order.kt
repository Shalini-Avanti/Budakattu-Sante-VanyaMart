package com.budakattusante.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Represents a preorder placed by a buyer.
 */
@Entity(tableName = "orders")
data class Order(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val productId: Int,
    val buyerId: Int,
    val productName: String,    // Denormalized for easy display
    val quantity: Int,
    val totalAmount: Double,
    val orderDate: Long = System.currentTimeMillis(),
    val status: String = "Confirmed"
)
