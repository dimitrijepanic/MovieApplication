package com.example.movieapplication.main.ui.trending

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.transition.TransitionInflater
import com.example.movieapplication.R
import com.example.movieapplication.databinding.FragmentTrendingBinding

class TrendingFragment : Fragment() {

    private lateinit var trendingViewModel: TrendingViewModel
    private var _binding: FragmentTrendingBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val inflater = TransitionInflater.from(requireContext())
        enterTransition = inflater.inflateTransition(R.transition.slide)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        trendingViewModel =
            ViewModelProvider(this).get(TrendingViewModel::class.java)

        _binding = FragmentTrendingBinding.inflate(inflater, container, false)
        val root: View = binding.root

        trendingViewModel.getTrendingMovies();

//        val textView: TextView = binding.textHome
//        trendingViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}