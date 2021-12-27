package com.example.movieapplication.main.ui.genrelist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.movieapplication.MainNavigationGraphDirections
import com.example.movieapplication.R
import com.example.movieapplication.databinding.FragmentGenreListBinding
import com.example.movieapplication.databinding.FragmentGenresBinding
import com.example.movieapplication.main.MainActivity
import com.example.movieapplication.main.ui.details.MovieDetailsFragmentArgs
import com.example.movieapplication.main.ui.trending.TrendingViewModel
import com.example.movieapplication.main.utility.adapter.MovieClickListener
import com.example.movieapplication.main.utility.adapter.MovieGridAdapter

class GenreListFragment : Fragment() {

    private lateinit var genreListViewModel: GenreListViewModel
    private lateinit var binding: FragmentGenreListBinding
    private lateinit var mainActivity: MainActivity
    private lateinit var viewModelFactory: GenreListViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        getFieldsValue(inflater)
        addListeners()
        setDataBinding()
        setTitleBar()

        return binding.root
    }

    private fun setTitleBar() {
        mainActivity.setIcon()
        mainActivity.setTitleValue(genreListViewModel.getGenreName() + " Movies")
    }

    private fun getFieldsValue(inflater: LayoutInflater) {
        viewModelFactory =
            GenreListViewModelFactory(GenreListFragmentArgs.fromBundle(requireArguments()).genre)
        genreListViewModel =
            ViewModelProvider(this, viewModelFactory)[GenreListViewModel::class.java]
        binding = FragmentGenreListBinding.inflate(inflater)
        mainActivity = requireActivity() as MainActivity
    }

    private fun setDataBinding() {
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = genreListViewModel
        binding.photosGrid.adapter = MovieGridAdapter(MovieClickListener {
            genreListViewModel.displayPropertyDetails(it)
        })
    }

    private fun addListeners() {
        genreListViewModel.navigateToSelectedProperty.observe(viewLifecycleOwner, Observer {
            it?.let {
                this.findNavController().navigate(
                    MainNavigationGraphDirections.actionGlobalMovieDetailsFragment(it)
                )
                genreListViewModel.displayPropertyDetailsComplete()
            }
        })
    }

}