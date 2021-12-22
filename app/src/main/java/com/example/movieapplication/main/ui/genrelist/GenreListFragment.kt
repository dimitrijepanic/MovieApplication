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
import com.example.movieapplication.main.ui.details.MovieDetailsFragmentArgs
import com.example.movieapplication.main.ui.trending.TrendingViewModel
import com.example.movieapplication.main.utility.adapter.MovieClickListener
import com.example.movieapplication.main.utility.adapter.MovieGridAdapter

class GenreListFragment : Fragment() {

    private lateinit var genreListViewModel: GenreListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        genreListViewModel =
            ViewModelProvider(this).get(GenreListViewModel::class.java)
        val binding = FragmentGenreListBinding.inflate(inflater)
        val arg = GenreListFragmentArgs.fromBundle(requireArguments()).genreId
        // menjaj ovo asap!!
        genreListViewModel.getData(arg)
        genreListViewModel.navigateToSelectedProperty.observe(viewLifecycleOwner, Observer {
            it?.let {
                this.findNavController().navigate(
                    MainNavigationGraphDirections.actionGlobalMovieDetailsFragment(it))
                genreListViewModel.displayMovieDetailsComplete()
            }
        })
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = genreListViewModel
        binding.photosGrid.adapter = MovieGridAdapter(MovieClickListener {
            genreListViewModel.displayMovieDetails(it)
        })
        return binding.root
    }


}