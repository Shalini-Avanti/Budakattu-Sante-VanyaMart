package com.budakattusante.ui.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.budakattusante.data.preferences.SessionManager
import com.budakattusante.databinding.ActivitySplashBinding
import com.budakattusante.ui.LeaderActivity
import com.budakattusante.ui.MainActivity
import com.budakattusante.ui.auth.LoginActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

/**
 * Entry point splash screen.
 * Checks existing session and routes to the correct activity.
 * Displays for 2.5 seconds before navigating.
 */
@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    @Inject
    lateinit var sessionManager: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Navigate after 2.5 seconds
        Handler(Looper.getMainLooper()).postDelayed({
            navigateToNextScreen()
        }, 4000)
    }

    private fun navigateToNextScreen() {
        val intent = if (sessionManager.isLoggedIn()) {
            when (sessionManager.getUserRole()) {
                "leader" -> Intent(this, LeaderActivity::class.java)
                else     -> Intent(this, MainActivity::class.java)
            }
        } else {
            Intent(this, LoginActivity::class.java)
        }
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
        finish()
    }
}
