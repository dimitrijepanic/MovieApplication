package com.example.movieapplication.main.network

import com.squareup.moshi.Json

data class CastListProperty(
    @Json(name = "cast") val cast: List<ActorProperty>,
)
