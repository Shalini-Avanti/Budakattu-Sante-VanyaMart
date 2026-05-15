package com.budakattusante.data.repository

import com.budakattusante.data.db.dao.UserDao
import com.budakattusante.data.db.entity.User
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepository @Inject constructor(private val userDao: UserDao) {

    suspend fun insertUser(user: User): Long = userDao.insertUser(user)

    suspend fun loginUser(phone: String, password: String): User? =
        userDao.loginUser(phone, password)

    suspend fun getUserByPhone(phone: String): User? = userDao.getUserByPhone(phone)

    suspend fun getUserById(id: Int): User? = userDao.getUserById(id)

    suspend fun phoneExists(phone: String): Boolean = userDao.phoneExists(phone) > 0
}
