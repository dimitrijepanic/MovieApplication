package com.example.movieapplication.main.ui.trending

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.transition.TransitionInflater
import com.example.movieapplication.MainNavigationGraphDirections
import com.example.movieapplication.R
import com.example.movieapplication.databinding.FragmentTrendingBinding
import com.example.movieapplication.main.utility.adapter.MovieClickListener
import com.example.movieapplication.main.utility.adapter.MovieGridAdapter

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
        trendingViewModel.navigateToSelectedProperty.observe(viewLifecycleOwner, Observer {
            it?.let {
                this.findNavController().navigate(
                    MainNavigationGraphDirections.actionGlobalMovieDetailsFragment(it)
                )
                trendingViewModel.displayMovieDetailsComplete()
            }
        })

        val binding = FragmentTrendingBinding.inflate(inflater)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = trendingViewModel
        binding.photosGrid.adapter = MovieGridAdapter(MovieClickListener {
            trendingViewModel.displayMovieDetails(it)
        })

        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.action_bar_menu, menu)
    }
}