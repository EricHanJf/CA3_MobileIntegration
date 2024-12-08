package com.example.ca3_mobileintegration.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ca3_mobileintegration.data.model.database.Plant
import com.example.ca3_mobileintegration.data.model.database.PlantDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class PlantViewModel(private val plantDao: PlantDao) : ViewModel() {

    fun addPlant(
        userId: Int,
        name: String,
        temperature: Float,
        humidity: Float,
        location: String,
        waterRequirement: String,
        imageUri: String? = null
    ) {
        viewModelScope.launch {
            val newPlant = Plant(
                userId = userId,
                plantname = name,
                temperature = temperature,
                humidity = humidity,
                location = location,
                waterRequirement = waterRequirement,
                imageUri = imageUri
            )
            plantDao.insert(newPlant)
        }
    }

    fun getPlantsByUser(userId: Int): Flow<List<Plant>> {
        // Assuming `getPlantsByUser` in PlantDao returns Flow<List<Plant>>
        return plantDao.getPlantsByUser(userId)
    }
}

