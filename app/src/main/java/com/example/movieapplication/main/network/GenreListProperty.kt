package com.example.movieapplication.main.network

import com.squareup.moshi.Json

data class GenreListProperty(
    @Json(name = "genres") val genres: List<GenreProperty>
)
