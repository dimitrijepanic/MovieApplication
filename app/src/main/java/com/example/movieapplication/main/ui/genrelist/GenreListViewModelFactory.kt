package com.example.movieapplication.main.ui.genrelist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.movieapplication.main.network.GenreProperty

class GenreListViewModelFactory(private val genreProperty: GenreProperty) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(GenreListViewModel::class.java)) {
            return GenreListViewModel(genreProperty) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}