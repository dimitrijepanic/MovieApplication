package com.example.movieapplication.main.ui.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.movieapplication.databinding.FragmentMovieDetailsBinding
import com.example.movieapplication.main.utility.adapter.CastGridAdapter

class MovieDetailsFragment : Fragment() {

    private lateinit var detailsViewModel: DetailsViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        detailsViewModel =
            ViewModelProvider(this).get(DetailsViewModel::class.java)

        val binding = FragmentMovieDetailsBinding.inflate(inflater)
        val arg = MovieDetailsFragmentArgs.fromBundle(requireArguments()).movie
        // ovo obavezno da promenis sutra
        detailsViewModel.setVal(arg)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = detailsViewModel
        binding.castGrid.adapter = CastGridAdapter()

        return binding.root
    }

}