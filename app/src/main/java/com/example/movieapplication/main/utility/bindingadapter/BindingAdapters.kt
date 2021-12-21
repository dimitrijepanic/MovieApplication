package com.example.movieapplication.main.utility.bindingadapter

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieapplication.main.network.GenreProperty
import com.example.movieapplication.main.network.MovieProperty
import com.example.movieapplication.main.utility.adapter.GenreGridAdapter
import com.example.movieapplication.main.utility.adapter.MovieGridAdapter

@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        val fullImagePath = "https://image.tmdb.org/t/p/w500/$imgUrl"
        val imgUri = fullImagePath.toUri().buildUpon().scheme("https").build()
        Glide.with(imgView.context)
            .load(imgUri)
            .into(imgView)
    }
}

@BindingAdapter("movieData")
fun bindMovieData(
    recyclerView: RecyclerView,
    data: List<MovieProperty>?
) {
    val adapter = recyclerView.adapter as MovieGridAdapter
    adapter.submitList(data)
}

@BindingAdapter("genreData")
fun bindGenreData(
    recyclerView: RecyclerView,
    data: List<GenreProperty>?
) {
    val adapter = recyclerView.adapter as GenreGridAdapter
    adapter.submitList(data)
}