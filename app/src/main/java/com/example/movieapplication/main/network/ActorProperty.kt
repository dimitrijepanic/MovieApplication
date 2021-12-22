package com.example.movieapplication.main.network

import com.squareup.moshi.Json

data class ActorProperty(
    @Json(name = "id") val id: Long,
    @Json(name = "name") val name: String,
    @Json(name = "character") val character: String,
    @Json(name = "profile_path") val profile_img: String?,
)
