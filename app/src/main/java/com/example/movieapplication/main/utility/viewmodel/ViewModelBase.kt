package com.example.movieapplication.main.utility.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapplication.main.network.MovieProperty
import kotlinx.coroutines.launch

abstract class ViewModelBase<T> : ViewModel() {

    enum class MovieApiStatus { LOADING, ERROR, DONE }

    private val _properties = MutableLiveData<List<T>>()
    val properties: LiveData<List<T>>
        get() = _properties

    private val _navigateToSelectedProperty = MutableLiveData<T?>()
    val navigateToSelectedProperty: LiveData<T?>
        get() = _navigateToSelectedProperty


    protected fun getNeededData() {
        viewModelScope.launch {
            try {
                val localMovies = getSpecificData()
                _properties.value = localMovies
            } catch (e: Exception) {
                _properties.value = ArrayList()
            }
        }
    }

    fun displayPropertyDetails(property: T) {
        _navigateToSelectedProperty.value = property
    }

    fun displayPropertyDetailsComplete() {
        _navigateToSelectedProperty.value = null
    }


    abstract suspend fun getSpecificData(): List<T>;
}