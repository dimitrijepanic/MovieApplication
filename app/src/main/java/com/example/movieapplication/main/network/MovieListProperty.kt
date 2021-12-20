package com.example.movieapplication.main.network

import com.squareup.moshi.Json

data class MovieListProperty(
    @Json(name = "results") val movies: List<MovieProperty>
)
