package com.example.movieapplication.main.ui.trending

import android.os.Bundle
import android.view.*
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.transition.TransitionInflater
import com.example.movieapplication.MainNavigationGraphDirections
import com.example.movieapplication.R
import com.example.movieapplication.databinding.FragmentTrendingBinding
import com.example.movieapplication.main.MainActivity
import com.example.movieapplication.main.utility.adapter.MovieClickListener
import com.example.movieapplication.main.utility.adapter.MovieGridAdapter

class TrendingFragment : Fragment() {

    private lateinit var trendingViewModel: TrendingViewModel
    private lateinit var mainActivity: MainActivity
    private lateinit var binding: FragmentTrendingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val inflater = TransitionInflater.from(requireContext())
        enterTransition = inflater.inflateTransition(R.transition.slide)
        mainActivity = requireActivity() as MainActivity
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        trendingViewModel =
            ViewModelProvider(this)[TrendingViewModel::class.java]

        binding = FragmentTrendingBinding.inflate(inflater)

        setTitleBar()
        addListeners()
        setDataBindingFields()

        return binding.root
    }

    private fun setTitleBar(){
        mainActivity.setTitleValue(getString(R.string.default_toolbar_title))
        mainActivity.clearIcon()
    }

    private fun setDataBindingFields() {
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = trendingViewModel
        binding.photosGrid.adapter = MovieGridAdapter(MovieClickListener {
            trendingViewModel.displayPropertyDetails(it)
        })
    }

    private fun addListeners() {
        trendingViewModel.navigateToSelectedProperty.observe(viewLifecycleOwner, Observer {
            it?.let {
                this.findNavController().navigate(
                    MainNavigationGraphDirections.actionGlobalMovieDetailsFragment(it)
                )
                trendingViewModel.displayPropertyDetailsComplete()
            }
        })
    }

}