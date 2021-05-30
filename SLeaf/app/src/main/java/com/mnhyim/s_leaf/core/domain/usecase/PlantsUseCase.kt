package com.mnhyim.s_leaf.core.domain.usecase

import com.mnhyim.s_leaf.core.data.remote.response.PlantResponse
import kotlinx.coroutines.flow.Flow

interface PlantsUseCase {

    fun getAllPlants(): Flow<List<PlantResponse>>
    fun getRandomPlants(): Flow<PlantResponse>
    fun scanImage(): Flow<PlantResponse>
}