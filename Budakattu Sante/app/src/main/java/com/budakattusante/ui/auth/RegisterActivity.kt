package com.budakattusante.ui.auth

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.budakattusante.databinding.ActivityRegisterBinding
import com.budakattusante.ui.LeaderActivity
import com.budakattusante.ui.MainActivity
import dagger.hilt.android.AndroidEntryPoint

/**
 * Registration screen for new buyers and cooperative leaders.
 * Role is selected via ChipGroup (buyer is default).
 */
@AndroidEntryPoint
class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    private val authViewModel: AuthViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        observeRegisterResult()
        setupClickListeners()
    }

    private fun setupClickListeners() {
        binding.btnRegister.setOnClickListener {
            val name     = binding.etName.text.toString().trim()
            val phone    = binding.etPhone.text.toString().trim()
            val village  = binding.etVillage.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()
            val role     = if (binding.chipLeader.isChecked) "leader" else "buyer"

            when {
                name.isEmpty()         -> toast("Please enter your name")
                phone.isEmpty()        -> toast("Please enter your phone number")
                phone.length != 10     -> toast("Enter a valid 10-digit phone number")
                village.isEmpty()      -> toast("Please enter your village name")
                password.length < 6    -> toast("Password must be at least 6 characters")
                else -> authViewModel.register(name, phone, village, password, role)
            }
        }

        binding.tvLogin.setOnClickListener {
            finish() // Go back to login
        }
    }

    private fun observeRegisterResult() {
        authViewModel.registerResult.observe(this) { result ->
            result.onSuccess { user ->
                toast("Welcome, ${user.name}!")
                val intent = when (user.role) {
                    "leader" -> Intent(this, LeaderActivity::class.java)
                    else     -> Intent(this, MainActivity::class.java)
                }
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
                finish()
            }
            result.onFailure { e ->
                toast(e.message ?: "Registration failed")
            }
        }
    }

    private fun toast(msg: String) =
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}
