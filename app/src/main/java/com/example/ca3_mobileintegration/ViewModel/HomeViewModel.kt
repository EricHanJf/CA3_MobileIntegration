package com.example.ca3_mobileintegration.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ca3_mobileintegration.data.model.database.User
import com.example.ca3_mobileintegration.data.model.database.UserDao
import kotlinx.coroutines.launch

class HomeViewModel(private val userDao: UserDao) : ViewModel() {

    var user: User? = null
        private set

    fun fetchUserData(userId: Int) {
        viewModelScope.launch {
            user = userDao.getUserById(userId)
        }
    }
}