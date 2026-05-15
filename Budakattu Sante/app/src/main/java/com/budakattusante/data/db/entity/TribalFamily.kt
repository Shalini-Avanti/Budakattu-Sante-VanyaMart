package com.budakattusante.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Represents a tribal family registered in the cooperative.
 */
@Entity(tableName = "tribal_families")
data class TribalFamily(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val familyName: String,
    val leaderName: String,
    val village: String,
    val tribe: String,
    val contactPhone: String
)
