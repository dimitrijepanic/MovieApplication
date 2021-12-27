package com.example.movieapplication.boarding

import android.app.ActivityOptions
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.movieapplication.databinding.ActivityBoardingBinding
import com.example.movieapplication.main.MainActivity

class BoardingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBoardingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityBoardingBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    public suspend fun sendIntent(){
        val intent = Intent(
            this,
            MainActivity::class.java
        )
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP;
        startActivity(
            intent
        )
        finish()
    }
}