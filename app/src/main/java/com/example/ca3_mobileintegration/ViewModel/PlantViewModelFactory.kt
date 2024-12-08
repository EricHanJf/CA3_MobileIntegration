package com.example.ca3_mobileintegration.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.ca3_mobileintegration.data.model.database.PlantDao

class PlantViewModelFactory(private val plantDao: PlantDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PlantViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return PlantViewModel(plantDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}