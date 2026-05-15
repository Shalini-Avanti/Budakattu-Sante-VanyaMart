package com.budakattusante.data.preferences

import android.content.Context
import android.content.SharedPreferences
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Manages user session using SharedPreferences.
 * Stores login state between app restarts.
 */
@Singleton
class SessionManager @Inject constructor(
    @ApplicationContext private val context: Context
) {
    private val prefs: SharedPreferences =
        context.getSharedPreferences("budakattusante_session", Context.MODE_PRIVATE)

    companion object {
        private const val KEY_USER_ID = "user_id"
        private const val KEY_USER_NAME = "user_name"
        private const val KEY_USER_ROLE = "user_role"
        private const val KEY_USER_PHONE = "user_phone"
        private const val KEY_USER_VILLAGE = "user_village"
        private const val KEY_IS_LOGGED_IN = "is_logged_in"
    }

    /** Save user session after successful login or registration */
    fun saveSession(id: Int, name: String, role: String, phone: String, village: String) {
        prefs.edit().apply {
            putInt(KEY_USER_ID, id)
            putString(KEY_USER_NAME, name)
            putString(KEY_USER_ROLE, role)
            putString(KEY_USER_PHONE, phone)
            putString(KEY_USER_VILLAGE, village)
            putBoolean(KEY_IS_LOGGED_IN, true)
            apply()
        }
    }

    fun isLoggedIn(): Boolean = prefs.getBoolean(KEY_IS_LOGGED_IN, false)
    fun getUserId(): Int = prefs.getInt(KEY_USER_ID, -1)
    fun getUserName(): String = prefs.getString(KEY_USER_NAME, "User") ?: "User"
    fun getUserRole(): String = prefs.getString(KEY_USER_ROLE, "buyer") ?: "buyer"
    fun getUserPhone(): String = prefs.getString(KEY_USER_PHONE, "") ?: ""
    fun getUserVillage(): String = prefs.getString(KEY_USER_VILLAGE, "") ?: ""

    /** Clear session on logout */
    fun clearSession() {
        prefs.edit().clear().apply()
    }
}
