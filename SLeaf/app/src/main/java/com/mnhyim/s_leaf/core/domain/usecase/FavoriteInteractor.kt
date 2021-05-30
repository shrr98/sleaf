package com.mnhyim.s_leaf.core.domain.usecase

import com.mnhyim.s_leaf.core.domain.model.Plant
import com.mnhyim.s_leaf.core.domain.repository.IPlantsRepository

class FavoriteInteractor(private val favoriteRepository: IPlantsRepository) : FavoriteUseCase {

    override fun getAllFavorites() = favoriteRepository.getAllFavorites()

    override fun addFavorite(plant: Plant) {
        favoriteRepository.addFavorite(plant)
    }

}