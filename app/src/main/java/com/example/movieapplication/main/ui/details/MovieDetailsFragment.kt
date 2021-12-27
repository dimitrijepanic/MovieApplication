package com.example.movieapplication.main.ui.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.movieapplication.MainNavigationGraphDirections
import com.example.movieapplication.databinding.FragmentMovieDetailsBinding
import com.example.movieapplication.main.utility.adapter.CastGridAdapter
import com.example.movieapplication.main.MainActivity
import com.google.android.material.tabs.TabLayout
import com.example.movieapplication.R
import com.example.movieapplication.main.ui.genrelist.GenreListFragmentArgs
import com.example.movieapplication.main.ui.genrelist.GenreListViewModelFactory
import com.google.android.material.tabs.TabItem


class MovieDetailsFragment : Fragment() {

    private lateinit var detailsViewModel: DetailsViewModel
    private lateinit var binding: FragmentMovieDetailsBinding
    private lateinit var mainActivity: MainActivity
    private lateinit var navController: NavController
    private lateinit var viewModelFactory: DetailsViewModelFactory
    private var currentState = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        setFieldsValues(inflater)
        setListeners()
        animate()
        setDataBinding()

        return binding.root
    }

    private fun setFieldsValues(inflater: LayoutInflater) {
        viewModelFactory =
            DetailsViewModelFactory(MovieDetailsFragmentArgs.fromBundle(requireArguments()).movie)
        detailsViewModel =
            ViewModelProvider(this, viewModelFactory)[DetailsViewModel::class.java]
        mainActivity = requireActivity() as MainActivity
        binding = FragmentMovieDetailsBinding.inflate(inflater)
        navController = this.findNavController()
    }

    private fun animate() {
        val animationDuration = 1000
        val progress = detailsViewModel.movie.value?.vote_average?.toFloat() ?: 0.0F
        binding.progressCircular.setProgressWithAnimation(progress * 10, animationDuration)
    }

    private fun setDataBinding() {
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = detailsViewModel
        binding.castGrid.adapter = CastGridAdapter()
    }

    private fun toggleVisibility(toggle1: Int, toggle2: Int) {
        binding.castGrid.visibility = toggle1
        binding.movieOverview.visibility = toggle2
        binding.movieRating.visibility = toggle2
        binding.progressCircular.visibility = toggle2
    }

    private fun setListeners() {
        binding.topAppBar.setOnMenuItemClickListener { menuClickListener(it) }
        binding.topAppBar.setNavigationOnClickListener { navController.navigateUp() }
        binding.tablayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {

            override fun onTabSelected(tab: TabLayout.Tab?) {

                when (currentState) {
                    true -> toggleVisibility(View.GONE, View.VISIBLE)
                    else -> toggleVisibility(View.VISIBLE, View.GONE)
                }
                currentState = !currentState
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                // Handle tab reselect
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                // Handle tab unselect
            }
        })

    }

    private fun menuClickListener(menuItem: MenuItem): Boolean {
        return when (menuItem.itemId) {
            R.id.account -> {
                navController.navigate(MainNavigationGraphDirections.actionGlobalAccountFragment())
                true
            }
            else -> false
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainActivity.hideAppBar()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mainActivity.showAppBar()
    }

}