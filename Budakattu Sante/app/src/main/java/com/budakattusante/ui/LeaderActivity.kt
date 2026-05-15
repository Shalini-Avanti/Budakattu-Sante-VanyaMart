package com.budakattusante.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.budakattusante.R
import com.budakattusante.databinding.ActivityLeaderBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * Main activity for COOPERATIVE LEADER role.
 * Hosts the NavHostFragment with nav_leader.xml navigation graph.
 * BottomNavigationView controls:
 * Dashboard → Add Product → Manage → Analytics
 */
@AndroidEntryPoint
class LeaderActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLeaderBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLeaderBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        binding.bottomNavigation.setupWithNavController(navController)

        // FIX: Re-selecting a bottom nav item now always navigates back to that
        // destination's root (e.g. tapping "Dashboard" while on "Add" goes back;
        // tapping the already-active tab pops any sub-screens on its stack).
        binding.bottomNavigation.setOnItemReselectedListener { item ->
            navController.navigate(
                item.itemId,
                null,
                NavOptions.Builder()
                    .setLaunchSingleTop(true)
                    .setPopUpTo(item.itemId, inclusive = false)
                    .build()
            )
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}