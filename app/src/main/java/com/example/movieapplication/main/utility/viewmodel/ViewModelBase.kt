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

    private val _status = MutableLiveData<MovieApiStatus>()

    val status: LiveData<MovieApiStatus>
        get() = _status

    protected fun getNeededData() {
        _status.value = MovieApiStatus.LOADING
        viewModelScope.launch {
            try {
                val localMovies = getSpecificData()
                _properties.value = localMovies
                _status.value = MovieApiStatus.DONE
            } catch (e: Exception) {
                _status.value = MovieApiStatus.ERROR
                _properties.value = ArrayList()
            }
        }
        _status
    }

    fun displayMovieDetails(property: T) {
        _navigateToSelectedProperty.value = property
    }

    fun displayMovieDetailsComplete() {
        _navigateToSelectedProperty.value = null
    }


    abstract suspend fun getSpecificData(): List<T>;
}