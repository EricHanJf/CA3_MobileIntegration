package com.example.ca3_mobileintegration.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.ca3_mobileintegration.data.model.database.UserDao

class HomeViewModelFactory(private val userDao: UserDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(userDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}