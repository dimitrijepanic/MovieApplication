package com.example.movieapplication.main.ui.genres

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.movieapplication.MainNavigationGraphDirections
import com.example.movieapplication.R
import com.example.movieapplication.databinding.FragmentGenresBinding
import com.example.movieapplication.main.MainActivity
import com.example.movieapplication.main.ui.genrelist.GenreListFragmentDirections
import com.example.movieapplication.main.utility.adapter.GenreClickListener
import com.example.movieapplication.main.utility.adapter.GenreGridAdapter

class GenresFragment : Fragment() {

    private lateinit var genresViewModel: GenresViewModel
    private lateinit var binding: FragmentGenresBinding
    private lateinit var mainActivity: MainActivity

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        genresViewModel =
            ViewModelProvider(this)[GenresViewModel::class.java]

        binding = FragmentGenresBinding.inflate(inflater)
        mainActivity = requireActivity() as MainActivity
        setTitleBar()
        addListeners()
        setDataBinding()

        return binding.root
    }

    private fun setTitleBar(){
        mainActivity.clearIcon()
        mainActivity.setTitleValue(getString(R.string.genres_toolbar_title))
    }

    private fun setDataBinding() {
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = genresViewModel
        binding.photosGrid.adapter = GenreGridAdapter(GenreClickListener {
            genresViewModel.displayPropertyDetails(it)
        }, context)
    }

    private fun addListeners() {
        genresViewModel.navigateToSelectedProperty.observe(viewLifecycleOwner, Observer {
            it?.let {
                this.findNavController().navigate(
                    GenresFragmentDirections.actionNavigationGenresToGenreListFragment2(it)
                )
                genresViewModel.displayPropertyDetailsComplete()
            }
        })
    }

}