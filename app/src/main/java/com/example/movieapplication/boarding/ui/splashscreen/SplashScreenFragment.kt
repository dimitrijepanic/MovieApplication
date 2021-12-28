package com.example.movieapplication.boarding.ui.splashscreen

import android.animation.ObjectAnimator
import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.core.animation.doOnEnd
import androidx.core.animation.doOnStart
import androidx.lifecycle.lifecycleScope
import androidx.transition.TransitionInflater
import com.example.movieapplication.R
import com.example.movieapplication.boarding.BoardingActivity
import com.example.movieapplication.databinding.FragmentSplashScreenBinding
import com.example.movieapplication.main.MainActivity
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class SplashScreenFragment : Fragment() {

    private lateinit var binding: FragmentSplashScreenBinding
    private lateinit var boardingActivity: BoardingActivity

    init {
        startMainActivity()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val inflater = TransitionInflater.from(requireContext())
        exitTransition = inflater.inflateTransition(R.transition.fade)
        boardingActivity = requireActivity() as BoardingActivity
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSplashScreenBinding.inflate(inflater, container, false)
        animate()

        return binding.root
    }

    private fun animate() {

        val am = ObjectAnimator.ofFloat(binding.logo, "translationY", -250f).apply {
            duration = 1200
            start()
        }
        am.doOnEnd {
            binding.appName.startAnimation(AnimationUtils.loadAnimation(context, R.anim.fade_in))
            binding.appName.text = getString(R.string.app_name)
        }

    }

    private fun startMainActivity() {
        lifecycleScope.launch {
            delay(2000)
            sendIntent()
        }
    }

    private suspend fun sendIntent() {
        boardingActivity.sendIntent()
    }
}