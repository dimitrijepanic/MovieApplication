package com.example.movieapplication.main.utility.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapplication.main.network.MovieProperty
import kotlinx.coroutines.launch

abstract class ViewModelBase : ViewModel() {

    private val _movies = MutableLiveData<List<MovieProperty>>()
    val movies: LiveData<List<MovieProperty>>
        get() = _movies

    protected fun getNeededData() {
        viewModelScope.launch {
            try {
                val localMovies = getSpecificData()
                _movies.value = localMovies
            } catch (e: Exception) {
            }
        }
    }

    abstract suspend fun getSpecificData(): List<MovieProperty>;
}