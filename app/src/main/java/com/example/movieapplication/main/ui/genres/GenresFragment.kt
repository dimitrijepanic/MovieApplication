package com.example.movieapplication.main.ui.genres

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.movieapplication.MainNavigationGraphDirections
import com.example.movieapplication.databinding.FragmentGenresBinding
import com.example.movieapplication.main.ui.genrelist.GenreListFragmentDirections
import com.example.movieapplication.main.utility.adapter.GenreClickListener
import com.example.movieapplication.main.utility.adapter.GenreGridAdapter

class GenresFragment : Fragment() {

    private lateinit var genresViewModel: GenresViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        genresViewModel =
            ViewModelProvider(this).get(GenresViewModel::class.java)
        genresViewModel.navigateToSelectedProperty.observe(viewLifecycleOwner, Observer {
            it?.let {
                this.findNavController().navigate(
                    GenresFragmentDirections.actionNavigationGenresToGenreListFragment2(it.id)
                )
                genresViewModel.displayMovieDetailsComplete()
            }
        })
        val binding = FragmentGenresBinding.inflate(inflater)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = genresViewModel
        binding.photosGrid.adapter = GenreGridAdapter(GenreClickListener {
            genresViewModel.displayMovieDetails(it)
        })
        return binding.root
    }

}