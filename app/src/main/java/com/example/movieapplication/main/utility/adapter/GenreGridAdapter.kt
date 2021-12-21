package com.example.movieapplication.main.utility.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapplication.databinding.GenreItemViewBinding
import com.example.movieapplication.main.network.GenreProperty

class GenreGridAdapter : ListAdapter<GenreProperty,
        GenreGridAdapter.GenrePropertyViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): GenrePropertyViewHolder {
        return GenrePropertyViewHolder(
            GenreItemViewBinding.inflate(
                LayoutInflater.from(parent.context)
            )
        )
    }

    override fun onBindViewHolder(
        holder: GenrePropertyViewHolder,
        position: Int
    ) {
        val genrePropery = getItem(position)
        holder.bind(genrePropery)
    }

    class GenrePropertyViewHolder(
        private var binding:
        GenreItemViewBinding
    ) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(genreProperty: GenreProperty) {
            binding.genre = genreProperty
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<GenreProperty>() {
        override fun areItemsTheSame(oldItem: GenreProperty, newItem: GenreProperty): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: GenreProperty, newItem: GenreProperty): Boolean {
            return oldItem.id == newItem.id
        }
    }
}