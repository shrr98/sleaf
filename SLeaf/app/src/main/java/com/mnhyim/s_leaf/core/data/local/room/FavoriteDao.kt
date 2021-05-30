package com.mnhyim.s_leaf.core.data.local.room

import androidx.room.*
import com.mnhyim.s_leaf.core.data.local.entity.PlantEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(plantEntity: PlantEntity)

    @Update
    fun update(plantEntity: PlantEntity)

    @Delete
    suspend fun delete(plantEntity: PlantEntity)

    @Query("SELECT * from favorite ORDER BY id ASC")
    fun getAllFavorites(): Flow<List<PlantEntity>>
}