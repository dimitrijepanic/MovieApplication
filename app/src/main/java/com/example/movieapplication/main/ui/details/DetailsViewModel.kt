package com.example.movieapplication.main.ui.details


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapplication.main.network.API_KEY
import com.example.movieapplication.main.network.ActorProperty
import com.example.movieapplication.main.network.MovieApi
import com.example.movieapplication.main.network.MovieProperty
import kotlinx.coroutines.launch

class DetailsViewModel() : ViewModel() {

    private val _properties = MutableLiveData<List<ActorProperty>>()
    val properties: LiveData<List<ActorProperty>>
        get() = _properties

    private val _movie = MutableLiveData<MovieProperty>()
    val movie: LiveData<MovieProperty>
        get() = _movie

    fun setVal(movie: MovieProperty) {
        _movie.value = movie
        viewModelScope.launch {
            try {
                println(movie.id)
                val cast = MovieApi.retrofitService.getAllActors(movie.id, API_KEY)
                println(cast.cast)
                _properties.value = cast.cast
            } catch (e: Exception) {
                print(e.message)
            }
        }
    }
}