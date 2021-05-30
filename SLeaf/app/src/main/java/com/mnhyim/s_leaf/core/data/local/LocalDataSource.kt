package com.mnhyim.s_leaf.core.data.local

import com.mnhyim.s_leaf.core.data.local.entity.PlantEntity
import com.mnhyim.s_leaf.core.data.local.room.FavoriteDao
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class LocalDataSource(private val favoriteDao: FavoriteDao) {

    fun getAllFavorite(): Flow<List<PlantEntity>> = favoriteDao.getAllFavorites()

    suspend fun addFavorite(plant: PlantEntity) =  favoriteDao.insert(plant)

    suspend fun deleteFavorite(plant: PlantEntity) = favoriteDao.delete(plant)

}