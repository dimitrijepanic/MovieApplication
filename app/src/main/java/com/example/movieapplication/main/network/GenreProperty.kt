package com.example.movieapplication.main.network

import com.squareup.moshi.Json

data class GenreProperty(
    @Json(name = "id") val id: Long,
    @Json(name = "name") val name: String,
)