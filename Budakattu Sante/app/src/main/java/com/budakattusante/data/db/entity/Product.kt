package com.budakattusante.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Represents a tribal marketplace product.
 */
@Entity(tableName = "products")
data class Product(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val description: String,
    val category: String,       // "Forest Produce", "Handicrafts", etc.
    val imageRes: String,       // Drawable name (used for category icon mapping)
    val price: Double,          // Market price
    val mspPrice: Double,       // Minimum Support Price
    val stock: Int,
    val season: String,
    val tribalFamilyId: Int,
    val village: String,
    val audioText: String       // Text for TextToSpeech
)
