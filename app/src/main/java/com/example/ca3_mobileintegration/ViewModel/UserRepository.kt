package com.example.ca3_mobileintegration.ViewModel

import com.example.ca3_mobileintegration.data.model.database.User
import com.example.ca3_mobileintegration.data.model.database.UserDao

class UserRepository(private val userDao: UserDao) {

    // Insert a user into the database
    suspend fun registerUser(user: User) {
        userDao.insertUser(user)
    }

    // Validate user login by email
    suspend fun loginUser(email: String, password: String): User? {
        val user = userDao.getUserByEmail(email)
        return if (user != null && user.password == password) {
            user  // Return the user if the password matches
        } else {
            null  // Return null if the email or password is incorrect
        }
    }
}