package com.example.movieapplication.main.network

import com.squareup.moshi.Json

data class MovieProperty(
    @Json(name = "id") val id: Long,
    @Json(name = "title") val title: String,
    @Json(name = "poster_path") val imageSrc: String
)
