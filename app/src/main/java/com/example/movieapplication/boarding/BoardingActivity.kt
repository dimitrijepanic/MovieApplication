package com.example.movieapplication.boarding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.movieapplication.R
import com.example.movieapplication.databinding.ActivityBoardingBinding
import com.example.movieapplication.databinding.ActivityMainBinding

class BoardingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBoardingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityBoardingBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}