package com.mnhyim.s_leaf.utils

import com.mnhyim.s_leaf.core.data.local.entity.PlantEntity
import com.mnhyim.s_leaf.core.domain.model.Plant

object DataMapper {
    fun mapEntitiesToDomain(input: List<PlantEntity>): List<Plant> =
        input.map {
            Plant(
                id = it.id,
                desc = it.desc,
                className = it.className,
                name = it.name,
                scientificName = it.scientificName,
                imageURL = it.imageURL,
                isFavorite = it.isFavorite
            )
        }

    fun mapDomainToEntity(input: Plant) = PlantEntity(
        desc = input.desc,
        className = input.className,
        name = input.name,
        scientificName = input.scientificName,
        imageURL = input.imageURL,
        isFavorite = input.isFavorite
    )
}