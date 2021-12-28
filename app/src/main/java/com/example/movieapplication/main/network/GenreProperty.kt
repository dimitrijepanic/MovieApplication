package com.example.movieapplication.main.network

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GenreProperty(
    @Json(name = "id") val id: Long,
    @Json(name = "name") val name: String,
) : Parcelable