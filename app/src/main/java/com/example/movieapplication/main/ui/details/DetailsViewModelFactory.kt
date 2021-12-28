package com.example.movieapplication.main.ui.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.movieapplication.main.network.GenreProperty
import com.example.movieapplication.main.network.MovieProperty
import com.example.movieapplication.main.ui.genrelist.GenreListViewModel

class DetailsViewModelFactory(private val movieProperty: MovieProperty) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailsViewModel::class.java)) {
            return DetailsViewModel(movieProperty) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}