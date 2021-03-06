package com.example.movieapplication.main.ui.genres

import com.example.movieapplication.main.network.API_KEY
import com.example.movieapplication.main.network.GenreProperty
import com.example.movieapplication.main.network.MovieApi
import com.example.movieapplication.main.network.MovieProperty
import com.example.movieapplication.main.utility.viewmodel.ViewModelBase

class GenresViewModel() : ViewModelBase<GenreProperty>() {

    init {
        getNeededData()
    }


    override suspend fun getSpecificData(): List<GenreProperty> {
        return MovieApi.retrofitService.getAllGenres(API_KEY).genres
    }

}