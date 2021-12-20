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

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    public fun getTrendingMovies(){
        MovieApi.retrofitService.getProperties(API_KEY).enqueue(
            object: Callback<String> {
                override fun onResponse(call: Call<String>, response: Response<String>) {
                    val a: Int
                    println(response.body());
                }

                override fun onFailure(call: Call<String>, t: Throwable) {
                    println(t.message)
                    val a:Int
                }
            })
    }
}