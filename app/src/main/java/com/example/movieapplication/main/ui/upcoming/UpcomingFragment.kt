package com.example.movieapplication.main.ui.upcoming

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.movieapplication.R
import com.example.movieapplication.databinding.FragmentTrendingBinding
import com.example.movieapplication.databinding.FragmentUpcomingBinding
import com.example.movieapplication.main.adapter.MovieGridAdapter
import com.example.movieapplication.main.ui.trending.TrendingViewModel

class UpcomingFragment : Fragment() {

    private lateinit var upcomingViewModel: UpcomingViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        upcomingViewModel =
            ViewModelProvider(this).get(UpcomingViewModel::class.java)

        val binding = FragmentUpcomingBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewModel = upcomingViewModel
        binding.photosGrid.adapter = MovieGridAdapter()

        return binding.root
    }

}