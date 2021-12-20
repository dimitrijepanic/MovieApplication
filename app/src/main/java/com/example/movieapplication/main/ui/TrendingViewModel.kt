package com.example.movieapplication.main.ui.trending

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapplication.main.network.API_KEY
import com.example.movieapplication.main.network.MovieApi
import com.example.movieapplication.main.network.MovieListProperty
import kotlinx.coroutines.launch

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TrendingViewModel : ViewModel() {


    public fun getTrendingMovies() {
        viewModelScope.launch {
            try {
                val page1 = MovieApi.retrofitService.getProperties(API_KEY, 1)
                val page2 = MovieApi.retrofitService.getProperties(API_KEY, 2)
            } catch (e: Exception) {
            }
        }
    }
}