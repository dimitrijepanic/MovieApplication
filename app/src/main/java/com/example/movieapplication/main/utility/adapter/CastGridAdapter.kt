package com.example.movieapplication.main.utility.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapplication.R
import com.example.movieapplication.databinding.CastItemViewBinding
import com.example.movieapplication.main.network.ActorProperty

class CastGridAdapter : ListAdapter<ActorProperty,
        CastGridAdapter.CastPropertyViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CastPropertyViewHolder {
        return CastPropertyViewHolder(
            CastItemViewBinding.inflate(
                LayoutInflater.from(parent.context)
            )
        )
    }

    override fun onBindViewHolder(
        holder: CastPropertyViewHolder,
        position: Int
    ) {
        val castProperty = getItem(position)
        holder.bind(castProperty)
    }

    class CastPropertyViewHolder(
        private var binding:
        CastItemViewBinding
    ) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(actorProperty: ActorProperty) {
            binding.card.animation =  AnimationUtils.loadAnimation(this.itemView.context, R.anim.alpha)
            binding.cast = actorProperty
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<ActorProperty>() {
        override fun areItemsTheSame(oldItem: ActorProperty, newItem: ActorProperty): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: ActorProperty, newItem: ActorProperty): Boolean {
            return oldItem.id == newItem.id
        }
    }
}