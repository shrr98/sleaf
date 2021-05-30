package com.mnhyim.s_leaf.core.data.remote

import android.util.Log
import com.mnhyim.s_leaf.core.data.remote.api.ApiResponse
import com.mnhyim.s_leaf.core.data.remote.api.ApiService
import com.mnhyim.s_leaf.core.data.remote.response.PlantResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RemoteDataSource(private val apiService: ApiService) {

//    suspend fun getAllPlants(): Flow<ApiResponse<List<PlantResponse>>> {
//        return flow {
//            try {
//                val response = apiService.getAllPlants()
//                val dataArray = response
//                if (dataArray.isNotEmpty()) {
//                    emit(ApiResponse.Success(response))
//                } else {
//                    emit(ApiResponse.Empty)
//                }
//            } catch (e: Exception) {
//                emit(ApiResponse.Error(e.toString()))
//                Log.e("RemoteDataSource", e.toString())
//            }
//        }.flowOn(Dispatchers.IO)
//    }
}