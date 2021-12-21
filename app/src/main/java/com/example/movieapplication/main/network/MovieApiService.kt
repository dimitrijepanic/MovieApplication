package com.example.movieapplication.main.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL =
    "https://api.themoviedb.org/"

public const val API_KEY =
    "d31ea94a23521e1fe1840b5dbcac61d8"

public const val NUMBER_TO_SHOW =
    10

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface MovieApiService {
    @GET("3/trending/movie/day?")
    suspend fun getTrendingMovies(@Query("api_key") api_key: String, @Query("page") page: Int):
            MovieListProperty

    @GET("3/movie/upcoming?")
    suspend fun getUpcomingMovies(@Query("api_key") api_key: String, @Query("page") page: Int):
            MovieListProperty

}

object MovieApi {
    val retrofitService: MovieApiService by lazy {
        retrofit.create(MovieApiService::class.java)
    }
}