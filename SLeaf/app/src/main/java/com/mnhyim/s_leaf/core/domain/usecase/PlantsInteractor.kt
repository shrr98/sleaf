package com.mnhyim.s_leaf.core.domain.usecase

import com.mnhyim.s_leaf.core.data.remote.response.PlantResponse
import com.mnhyim.s_leaf.core.domain.repository.IPlantsRepository
import kotlinx.coroutines.flow.Flow

//class PlantsInteractor(private val favoriteRepository: IPlantsRepository): PlantsUseCase {
//
//    override fun getAllPlants(): Flow<List<PlantResponse>> {
//        return favoriteRepository.getAllPlants()
//    }
//
//    override fun getRandomPlants(): Flow<PlantResponse> {
//        return favoriteRepository.getRandomPlants()
//    }
//
//    override fun scanImage(): Flow<PlantResponse> {
//        return favoriteRepository.scanImage()
//    }
//}