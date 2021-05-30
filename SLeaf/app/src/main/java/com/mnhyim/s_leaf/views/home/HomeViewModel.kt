package com.mnhyim.s_leaf.views.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.mnhyim.s_leaf.core.domain.model.Plant
import com.mnhyim.s_leaf.core.domain.usecase.FavoriteUseCase
import com.mnhyim.s_leaf.core.domain.usecase.PlantsUseCase
import com.mnhyim.s_leaf.utils.DataMapper
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*

@FlowPreview
@ExperimentalCoroutinesApi
class HomeViewModel(private val plantsUseCase: PlantsUseCase, private val favoriteUseCase: FavoriteUseCase) : ViewModel() {
    val listPlants : LiveData<List<Plant>> = plantsUseCase.getAllPlants().asLiveData()

    fun addFavorite(plant: Plant) {
        favoriteUseCase.addFavorite(plant)
    }

    fun getPlant() {
        plantsUseCase.getPlant().asLiveData()
    }
}