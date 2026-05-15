package com.budakattusante.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Represents a registered user in the app.
 * Role can be "buyer" or "leader".
 */
@Entity(tableName = "users")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val phone: String,         // Used as unique login identifier
    val village: String,
    val password: String,
    val role: String           // "buyer" or "leader"
)
