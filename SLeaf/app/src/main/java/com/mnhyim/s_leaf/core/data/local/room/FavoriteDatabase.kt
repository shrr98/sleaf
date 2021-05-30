package com.mnhyim.s_leaf.core.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mnhyim.s_leaf.core.data.local.entity.PlantEntity

@Database(entities = [PlantEntity::class], version = 1, exportSchema = false)
abstract class FavoriteDatabase : RoomDatabase() {

    abstract fun favoriteDao(): FavoriteDao
}