package com.example.movieapplication.main.ui.details


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movieapplication.main.network.MovieProperty

class DetailsViewModel() : ViewModel() {
    private val _movie = MutableLiveData<MovieProperty>()
    val movie: LiveData<MovieProperty>
        get() = _movie

    fun setVal(movie: MovieProperty){
        _movie.value = movie
    }
}