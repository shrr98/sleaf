package com.mnhyim.s_leaf.core.domain.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import kotlinx.android.parcel.Parcelize
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem

@Parcelize
data class Plant(
    val id: Int = 0,
    val className: String,
    val name: String,
    val desc: String,
    val scientificName: String,
    val imageURL: List<String>,
    val isFavorite: Boolean
) : Parcelable