package com.example.movieapplication.main.ui.upcoming

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.movieapplication.MainNavigationGraphDirections
import com.example.movieapplication.R
import com.example.movieapplication.databinding.FragmentUpcomingBinding
import com.example.movieapplication.main.utility.adapter.MovieClickListener
import com.example.movieapplication.main.utility.adapter.MovieGridAdapter

class UpcomingFragment : Fragment() {

    private lateinit var upcomingViewModel: UpcomingViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        upcomingViewModel =
            ViewModelProvider(this).get(UpcomingViewModel::class.java)

        val binding = FragmentUpcomingBinding.inflate(inflater)
        upcomingViewModel.navigateToSelectedProperty.observe(viewLifecycleOwner, Observer {
            it?.let {
                this.findNavController().navigate(
                    MainNavigationGraphDirections.actionGlobalMovieDetailsFragment(it)
                )
                upcomingViewModel.displayMovieDetailsComplete()
            }
        })

        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = upcomingViewModel
        binding.photosGrid.adapter = MovieGridAdapter(MovieClickListener {
            upcomingViewModel.displayMovieDetails(it)
        })

        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.action_bar_menu, menu)
    }


}