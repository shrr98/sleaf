package com.mnhyim.s_leaf.core.domain.usecase

import com.mnhyim.s_leaf.core.data.remote.response.PlantResponse
import com.mnhyim.s_leaf.core.domain.model.Plant
import com.mnhyim.s_leaf.core.domain.repository.IPlantsRepository
import com.mnhyim.s_leaf.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class PlantsInteractor(private val favoriteRepository: IPlantsRepository): PlantsUseCase {

    override fun getAllPlants(): Flow<List<Plant>> {
        return favoriteRepository.getAllPlants()
    }

    override fun getPlant(): Flow<Plant> {
        return favoriteRepository.getPlant()
    }
//
//    override fun scanImage(): Flow<PlantResponse> {
//        return favoriteRepository.scanImage()
//    }
}