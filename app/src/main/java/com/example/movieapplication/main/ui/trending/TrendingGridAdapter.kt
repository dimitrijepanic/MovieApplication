package com.example.movieapplication.main.ui.trending

import android.graphics.Movie
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapplication.databinding.MovieItemViewBinding
import com.example.movieapplication.main.network.MovieProperty

class TrendingGridAdapter : ListAdapter<MovieProperty,
        TrendingGridAdapter.MoviePropertyViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TrendingGridAdapter.MoviePropertyViewHolder {
        return MoviePropertyViewHolder(
            MovieItemViewBinding.inflate(
                LayoutInflater.from(parent.context)
            )
        )
    }

    override fun onBindViewHolder(
        holder: TrendingGridAdapter.MoviePropertyViewHolder,
        position: Int
    ) {
        val marsProperty = getItem(position)
        holder.bind(marsProperty)
    }

    class MoviePropertyViewHolder(
        private var binding:
        MovieItemViewBinding
    ) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(movieProperty: MovieProperty) {
            binding.movie = movieProperty
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<MovieProperty>() {
        override fun areItemsTheSame(oldItem: MovieProperty, newItem: MovieProperty): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: MovieProperty, newItem: MovieProperty): Boolean {
            return oldItem.id == newItem.id
        }
    }
}

