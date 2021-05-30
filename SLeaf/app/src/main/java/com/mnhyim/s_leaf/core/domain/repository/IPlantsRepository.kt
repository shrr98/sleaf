package com.mnhyim.s_leaf.core.domain.repository

import com.mnhyim.s_leaf.core.domain.model.Plant
import kotlinx.coroutines.flow.Flow

interface IPlantsRepository {

    fun getAllFavorites(): Flow<List<Plant>>
    fun addFavorite(plant: Plant)
    fun getAllPlants(): Flow<List<Plant>>
//    fun getRandomPlants(): Flow<Plant>
//    fun scanImage(): Flow<Plant>
}