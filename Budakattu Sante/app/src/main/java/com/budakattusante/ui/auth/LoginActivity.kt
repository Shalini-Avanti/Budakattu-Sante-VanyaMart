package com.budakattusante.ui.auth

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.budakattusante.databinding.ActivityLoginBinding
import com.budakattusante.ui.LeaderActivity
import com.budakattusante.ui.MainActivity
import dagger.hilt.android.AndroidEntryPoint

/**
 * Login screen — uses phone number and password stored locally in Room.
 * Default admin: 9999999999 / admin123
 */
@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private val authViewModel: AuthViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        observeLoginResult()
        setupClickListeners()
    }

    private fun setupClickListeners() {
        binding.btnLogin.setOnClickListener {
            val phone = binding.etPhone.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()

            when {
                phone.isEmpty()    -> toast("Please enter your phone number")
                password.isEmpty() -> toast("Please enter your password")
                phone.length != 10 -> toast("Enter a valid 10-digit phone number")
                else               -> authViewModel.login(phone, password)
            }
        }

        binding.tvRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }

    private fun observeLoginResult() {
        authViewModel.loginResult.observe(this) { result ->
            result.onSuccess { user ->
                val intent = when (user.role) {
                    "leader" -> Intent(this, LeaderActivity::class.java)
                    else     -> Intent(this, MainActivity::class.java)
                }
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
                finish()
            }
            result.onFailure { e ->
                toast(e.message ?: "Login failed")
            }
        }
    }

    private fun toast(msg: String) =
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}
