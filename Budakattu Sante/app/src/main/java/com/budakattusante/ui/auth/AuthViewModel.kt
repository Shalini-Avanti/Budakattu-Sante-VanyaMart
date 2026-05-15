package com.budakattusante.ui.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.budakattusante.data.db.entity.User
import com.budakattusante.data.preferences.SessionManager
import com.budakattusante.data.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * ViewModel for Login and Register screens.
 * Handles local authentication via Room database.
 */
@HiltViewModel
class AuthViewModel @Inject constructor(
    private val userRepository: UserRepository,
    private val sessionManager: SessionManager
) : ViewModel() {

    private val _loginResult = MutableLiveData<Result<User>>()
    val loginResult: LiveData<Result<User>> = _loginResult

    private val _registerResult = MutableLiveData<Result<User>>()
    val registerResult: LiveData<Result<User>> = _registerResult

    /** Authenticate user by phone + password */
    fun login(phone: String, password: String) {
        viewModelScope.launch {
            val user = userRepository.loginUser(phone, password)
            if (user != null) {
                sessionManager.saveSession(
                    id = user.id,
                    name = user.name,
                    role = user.role,
                    phone = user.phone,
                    village = user.village
                )
                _loginResult.value = Result.success(user)
            } else {
                _loginResult.value = Result.failure(Exception("Invalid phone number or password."))
            }
        }
    }

    /** Register a new user if phone not already taken */
    fun register(name: String, phone: String, village: String, password: String, role: String) {
        viewModelScope.launch {
            val phoneAlreadyExists = userRepository.phoneExists(phone)
            if (phoneAlreadyExists) {
                _registerResult.value = Result.failure(Exception("Phone number already registered."))
                return@launch
            }
            val newUser = User(
                name = name,
                phone = phone,
                village = village,
                password = password,
                role = role
            )
            val generatedId = userRepository.insertUser(newUser)
            if (generatedId > 0) {
                sessionManager.saveSession(
                    id = generatedId.toInt(),
                    name = name,
                    role = role,
                    phone = phone,
                    village = village
                )
                _registerResult.value = Result.success(newUser.copy(id = generatedId.toInt()))
            } else {
                _registerResult.value = Result.failure(Exception("Registration failed. Please try again."))
            }
        }
    }

    fun logout() {
        sessionManager.clearSession()
    }
}
