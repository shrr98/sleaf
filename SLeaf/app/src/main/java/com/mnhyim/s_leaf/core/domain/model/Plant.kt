package com.mnhyim.s_leaf.core.domain.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Plant(
    val id: Int,
    val className: String,
    val name: String,
    val desc: String,
    val scientificName: String,
    val imageURL: String,
    val isFavorite: Boolean
) : Parcelable