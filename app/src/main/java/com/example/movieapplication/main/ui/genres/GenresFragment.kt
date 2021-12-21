package com.example.movieapplication.main.ui.genres

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.movieapplication.databinding.FragmentGenresBinding
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

        val binding = FragmentGenresBinding.inflate(inflater)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = genresViewModel
        binding.photosGrid.adapter = GenreGridAdapter()
        return binding.root
    }

}