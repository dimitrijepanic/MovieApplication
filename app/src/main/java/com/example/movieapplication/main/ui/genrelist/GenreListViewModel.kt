package com.example.movieapplication.main.ui.genrelist

import com.example.movieapplication.main.network.API_KEY
import com.example.movieapplication.main.network.GenreProperty
import com.example.movieapplication.main.network.MovieApi
import com.example.movieapplication.main.network.MovieProperty
import com.example.movieapplication.main.utility.viewmodel.ViewModelBase

class GenreListViewModel : ViewModelBase<MovieProperty>() {
    private var id: Long = 0

    public fun getData(id: Long) {
        this.id = id;
        getNeededData()
    }

    override suspend fun getSpecificData(): List<MovieProperty> {
        val page1 = MovieApi.retrofitService.getGenreMovies(API_KEY, 1, id)
        val page2 = MovieApi.retrofitService.getGenreMovies(API_KEY, 2, id)
        val page3 = MovieApi.retrofitService.getGenreMovies(API_KEY, 3, id)
        return page1.movies + page2.movies + page3.movies
    }

}