package com.example.movieapplication.main.network

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieProperty(
    @Json(name = "id") val id: Long,
    @Json(name = "title") val title: String,
    @Json(name = "poster_path") val imageSrc: String,
    @Json(name = "vote_average") val vote_average: Double
) : Parcelable
