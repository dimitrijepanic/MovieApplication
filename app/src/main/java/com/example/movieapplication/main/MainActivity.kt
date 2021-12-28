package com.example.movieapplication.main

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.net.toUri
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.bumptech.glide.Glide
import com.example.movieapplication.MainNavigationGraphDirections
import com.example.movieapplication.R
import com.example.movieapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private lateinit var navHost: Fragment
    private var state = false
    private var accountState = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView
        setListeners()

        navView.setupWithNavController(navController)
        state = true
    }

    private fun setListeners() {
        binding.topAppBar.setOnMenuItemClickListener { menuClickListener(it) }
        binding.topAppBar.setNavigationOnClickListener { onSupportNavigateUp() }
        setIconChangeStateListener()
        setOnDestinationChangedListener()
    }

    private fun setOnDestinationChangedListener() {
        navController.addOnDestinationChangedListener { _, destination, _ ->

            when (destination.id) {
                R.id.navigation_account -> {
                    onAccountDestinationSelected()
                }
                R.id.movieDetailsFragment -> binding.navView.visibility = View.GONE
                else -> binding.navView.visibility = View.VISIBLE
            }
        }
    }

    private fun onAccountDestinationSelected() {
        binding.navView.visibility = View.GONE
        binding.topAppBar.navigationIcon =
            resources.getDrawable(R.drawable.outline_arrow_back_24, theme)
        accountState = true
    }

    private fun setIconChangeStateListener() {
        navHost = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_activity_main)!!
        navController = findNavController(R.id.nav_host_fragment_activity_main)
//        navHost.childFragmentManager.addOnBackStackChangedListener {
//            changeIcon()
//        }
    }

    private fun menuClickListener(menuItem: MenuItem): Boolean {
        return when (menuItem.itemId) {
            R.id.account -> {
                navController.navigate(MainNavigationGraphDirections.actionGlobalAccountFragment())
                true
            }
            else -> false
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()
    }

    public fun setTitleValue(title: String) {
        if (state)
            binding.topAppBar.title = title
    }

    public fun setIcon() {
        binding.topAppBar.navigationIcon =
            resources.getDrawable(R.drawable.outline_arrow_back_24, theme)
    }

    public fun clearIcon() {
        if (state)
            binding.topAppBar.navigationIcon = null
    }

//    @SuppressLint("UseCompatLoadingForDrawables")
//    public fun changeIcon() {
//        if (navHost.childFragmentManager.backStackEntryCount > 1) {
//
//        } else {
//            if (!accountState)
//
//            accountState = false
//        }
//
//    }

    public fun hideAppBar() {
        binding.topAppBar.visibility = View.GONE
    }

    public fun showAppBar() {
        binding.topAppBar.visibility = View.VISIBLE
    }

    public fun hideMenuItem() {
        binding.topAppBar.menu.setGroupVisible(0, false)
    }

    public fun showMenuItem() {
        binding.topAppBar.menu.setGroupVisible(0, true)
    }

}