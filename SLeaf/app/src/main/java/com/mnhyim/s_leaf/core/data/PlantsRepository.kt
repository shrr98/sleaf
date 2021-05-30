package com.mnhyim.s_leaf.core.data

import com.mnhyim.s_leaf.core.data.local.LocalDataSource
import com.mnhyim.s_leaf.core.data.remote.RemoteDataSource
import com.mnhyim.s_leaf.core.domain.model.Plant
import com.mnhyim.s_leaf.core.domain.repository.IPlantsRepository
import com.mnhyim.s_leaf.utils.AppExecutors
import com.mnhyim.s_leaf.utils.DataMapper
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class PlantsRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : IPlantsRepository {

    override fun getAllFavorites(): Flow<List<Plant>> {
        return localDataSource.getAllFavorite().map {
            DataMapper.mapEntitiesToDomain(it)
        }
    }

    override fun addFavorite(plant: Plant) {
        CoroutineScope(Dispatchers.Main).launch {
            val plantEntity = DataMapper.mapDomainToEntity(plant)
            localDataSource.addFavorite(plantEntity)
        }
    }

//    override fun getAllPlants(): Flow<List<Plant>> {
//        TODO("Not yet implemented")
//    }
//
//    override fun getRandomPlants(): Flow<Plant> {
//        TODO("Not yet implemented")
//    }
//
//    override fun scanImage(): Flow<Plant> {
//        TODO("Not yet implemented")
//    }
}