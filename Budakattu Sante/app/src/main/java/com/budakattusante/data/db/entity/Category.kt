package com.budakattusante.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Product category (e.g., Forest Produce, Handicrafts).
 */
@Entity(tableName = "categories")
data class Category(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val iconName: String
)
