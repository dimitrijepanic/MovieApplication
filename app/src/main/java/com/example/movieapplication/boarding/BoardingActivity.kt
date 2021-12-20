package com.example.movieapplication.boarding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.movieapplication.databinding.ActivityBoardingBinding

class BoardingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBoardingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityBoardingBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}