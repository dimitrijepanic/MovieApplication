package com.example.movieapplication.main

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieapplication.main.network.MovieProperty
import com.example.movieapplication.main.ui.trending.TrendingGridAdapter

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

@BindingAdapter("listData")
fun bindRecyclerView(
    recyclerView: RecyclerView,
    data: List<MovieProperty>?
) {
    val adapter = recyclerView.adapter as TrendingGridAdapter
    adapter.submitList(data)
}