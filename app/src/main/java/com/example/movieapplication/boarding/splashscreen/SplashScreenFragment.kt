package com.example.movieapplication.boarding.splashscreen

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.transition.TransitionInflater
import com.example.movieapplication.R
import com.example.movieapplication.databinding.FragmentSplashScreenBinding
import com.example.movieapplication.main.MainActivity
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class SplashScreenFragment : Fragment() {

    private lateinit var binding: FragmentSplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val inflater = TransitionInflater.from(requireContext())
        exitTransition = inflater.inflateTransition(R.transition.fade)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSplashScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    init {
        startMainActivity()
    }

    private fun startMainActivity() {
        lifecycleScope.launch {
            delay(2000)
            sendIntent()
        }
    }

    private suspend fun sendIntent() {
        startActivity(Intent(this.requireContext(), MainActivity::class.java),
            ActivityOptions.makeSceneTransitionAnimation(requireActivity()).toBundle())
    }
}