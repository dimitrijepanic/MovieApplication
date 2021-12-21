package com.example.movieapplication.main.utility.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapplication.main.network.MovieProperty
import kotlinx.coroutines.launch

abstract class ViewModelBase<T> : ViewModel() {

    private val _properties = MutableLiveData<List<T>>()
    val properties: LiveData<List<T>>
        get() = _properties

    protected fun getNeededData() {
        viewModelScope.launch {
            try {
                val localMovies = getSpecificData()
                _properties.value = localMovies
            } catch (e: Exception) {
                print(e.message)
            }
        }
    }

    abstract suspend fun getSpecificData(): List<T>;
}