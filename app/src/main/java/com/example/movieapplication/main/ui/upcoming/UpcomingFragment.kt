package com.example.movieapplication.main.ui.upcoming

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.movieapplication.MainNavigationGraphDirections
import com.example.movieapplication.R
import com.example.movieapplication.databinding.FragmentTrendingBinding
import com.example.movieapplication.databinding.FragmentUpcomingBinding
import com.example.movieapplication.main.MainActivity
import com.example.movieapplication.main.utility.adapter.MovieClickListener
import com.example.movieapplication.main.utility.adapter.MovieGridAdapter

class UpcomingFragment : Fragment() {

    private lateinit var upcomingViewModel: UpcomingViewModel
    private lateinit var mainActivity: MainActivity
    private lateinit var binding: FragmentUpcomingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        upcomingViewModel =
            ViewModelProvider(this)[UpcomingViewModel::class.java]
        binding = FragmentUpcomingBinding.inflate(inflater)
        mainActivity = requireActivity() as MainActivity

        setTitleBar()
        setDataBindingFields()
        addListeners()

        return binding.root
    }
    private fun setTitleBar(){
        mainActivity.setTitleValue(getString(R.string.upcoming_toolbar_title))
        mainActivity.clearIcon()
    }

    private fun setDataBindingFields() {
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = upcomingViewModel
        binding.photosGrid.adapter = MovieGridAdapter(MovieClickListener {
            upcomingViewModel.displayPropertyDetails(it)
        })
    }

    private fun addListeners() {
        upcomingViewModel.navigateToSelectedProperty.observe(viewLifecycleOwner, Observer {
            it?.let {
                this.findNavController().navigate(
                    MainNavigationGraphDirections.actionGlobalMovieDetailsFragment(it)
                )
                upcomingViewModel.displayPropertyDetailsComplete()
            }
        })
    }
}