package com.example.movieapplication.main.ui.trending

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapplication.main.network.API_KEY
import com.example.movieapplication.main.network.MovieApi
import com.example.movieapplication.main.network.MovieProperty
import kotlinx.coroutines.launch


class TrendingViewModel : ViewModel() {

    private val _movie = MutableLiveData<MovieProperty>()
    val movie: LiveData<MovieProperty>
        get() = _movie

    private val _movies = MutableLiveData<List<MovieProperty>>()
    val movies: LiveData<List<MovieProperty>>
        get() = _movies

    public fun getTrendingMovies() {
        viewModelScope.launch {
            try {
                val page1 = MovieApi.retrofitService.getProperties(API_KEY, 1)
                val page2 = MovieApi.retrofitService.getProperties(API_KEY, 2)
                _movies.value = page1.movies + page2.movies
                _movie.value = page1.movies[0]
            } catch (e: Exception) {
            }
        }
    }
}