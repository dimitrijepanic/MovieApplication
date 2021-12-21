package com.example.movieapplication.main.ui.upcoming

import com.example.movieapplication.main.network.API_KEY
import com.example.movieapplication.main.network.MovieApi
import com.example.movieapplication.main.network.MovieProperty
import com.example.movieapplication.main.utility.viewmodel.ViewModelBase

class UpcomingViewModel : ViewModelBase<MovieProperty>() {

    init {
        getNeededData()
    }

    override suspend fun getSpecificData(): List<MovieProperty> {
        val page1 = MovieApi.retrofitService.getUpcomingMovies(API_KEY, 1)
        val page2 = MovieApi.retrofitService.getUpcomingMovies(API_KEY, 2)
        val page3 = MovieApi.retrofitService.getUpcomingMovies(API_KEY, 3)
        return page1.movies + page2.movies + page3.movies
    }

}