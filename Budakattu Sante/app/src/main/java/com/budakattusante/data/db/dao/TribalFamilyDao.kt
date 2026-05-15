package com.budakattusante.data.db.dao

import androidx.room.*
import com.budakattusante.data.db.entity.TribalFamily

@Dao
interface TribalFamilyDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertTribalFamily(family: TribalFamily): Long

    @Query("SELECT * FROM tribal_families")
    suspend fun getAllFamilies(): List<TribalFamily>

    @Query("SELECT * FROM tribal_families WHERE id = :id LIMIT 1")
    suspend fun getFamilyById(id: Int): TribalFamily?
}
