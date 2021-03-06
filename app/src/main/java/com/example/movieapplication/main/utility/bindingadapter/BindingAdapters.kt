package com.example.movieapplication.main.utility.bindingadapter

import android.view.View
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieapplication.R
import com.example.movieapplication.main.network.ActorProperty
import com.example.movieapplication.main.network.GenreProperty
import com.example.movieapplication.main.network.MovieProperty
import com.example.movieapplication.main.utility.adapter.CastGridAdapter
import com.example.movieapplication.main.utility.adapter.GenreGridAdapter
import com.example.movieapplication.main.utility.adapter.MovieGridAdapter
import com.example.movieapplication.main.utility.viewmodel.ViewModelBase

@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        val fullImagePath = "https://image.tmdb.org/t/p/w300/$imgUrl"
        val imgUri = fullImagePath.toUri().buildUpon().scheme("https").build()
        Glide.with(imgView.context)
            .load(imgUri)
            .placeholder(R.drawable.loading_animation)
            .into(imgView)
    }
}

@BindingAdapter("detailsImageUrl")
fun bindDetailsImage(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        val fullImagePath = "https://image.tmdb.org/t/p/w500/$imgUrl"
        val imgUri = fullImagePath.toUri().buildUpon().scheme("https").build()
        Glide.with(imgView.context)
            .load(imgUri)
            .placeholder(R.drawable.loading_animation)
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

@BindingAdapter("castData")
fun bindCastData(
    recyclerView: RecyclerView,
    data: List<ActorProperty>?
) {
    val adapter = recyclerView.adapter as CastGridAdapter
    adapter.submitList(data)
}