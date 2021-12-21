package com.example.movieapplication.main.ui.upcoming

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
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
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = upcomingViewModel
        binding.photosGrid.adapter = MovieGridAdapter(MovieClickListener { id ->
            Toast.makeText(context, "${id}", Toast.LENGTH_SHORT).show()
        })

        return binding.root
    }

}