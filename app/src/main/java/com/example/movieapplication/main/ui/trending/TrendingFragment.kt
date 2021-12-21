package com.example.movieapplication.main.ui.trending

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.transition.TransitionInflater
import com.example.movieapplication.R
import com.example.movieapplication.databinding.FragmentTrendingBinding

class TrendingFragment : Fragment() {

    private lateinit var trendingViewModel: TrendingViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val inflater = TransitionInflater.from(requireContext())
        enterTransition = inflater.inflateTransition(R.transition.slide)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        trendingViewModel =
            ViewModelProvider(this).get(TrendingViewModel::class.java)

        val binding = FragmentTrendingBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewModel = trendingViewModel
        binding.photosGrid.adapter = TrendingGridAdapter()

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}