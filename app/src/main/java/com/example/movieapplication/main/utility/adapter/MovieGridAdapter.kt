package com.example.movieapplication.main.utility.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapplication.R
import com.example.movieapplication.databinding.MovieItemViewBinding
import com.example.movieapplication.main.network.MovieProperty

class MovieGridAdapter(private val clickListener: MovieClickListener) : ListAdapter<MovieProperty,
        MovieGridAdapter.MoviePropertyViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MoviePropertyViewHolder {
        return MoviePropertyViewHolder(
            MovieItemViewBinding.inflate(
                LayoutInflater.from(parent.context)
            )
        )
    }

    override fun onBindViewHolder(
        holder: MoviePropertyViewHolder,
        position: Int
    ) {
        val movieProperty = getItem(position)
        holder.bind(movieProperty, clickListener)
    }

    class MoviePropertyViewHolder(
        private var binding:
        MovieItemViewBinding
    ) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(movieProperty: MovieProperty, clickListener: MovieClickListener) {
            binding.card.animation =  AnimationUtils.loadAnimation(this.itemView.context, R.anim.alpha)
            binding.movie = movieProperty
            binding.clickListener = clickListener
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

class MovieClickListener(val clickListener: (movie: MovieProperty) -> Unit) {
    fun onClick(movie: MovieProperty) = clickListener(movie)
}


