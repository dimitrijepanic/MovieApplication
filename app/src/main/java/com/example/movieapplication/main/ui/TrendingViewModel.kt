package com.example.movieapplication.main.ui.trending

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movieapplication.main.network.API_KEY
import com.example.movieapplication.main.network.MovieApi

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TrendingViewModel : ViewModel() {

    public fun getTrendingMovies(){
        MovieApi.retrofitService.getProperties(API_KEY).enqueue(
            object: Callback<String> {
                override fun onResponse(call: Call<String>, response: Response<String>) {
                    println(response.body());
                }

                override fun onFailure(call: Call<String>, t: Throwable) {
                    println(t.message)
                }
            })
    }
}