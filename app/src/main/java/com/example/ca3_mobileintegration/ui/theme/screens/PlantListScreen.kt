package com.example.ca3_mobileintegration.ui.theme.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

// Sample data class representing a plant
data class DetailedPlant(val name: String, val moistureLevel: Int, val waterRequirement: Int)

@Composable
fun PlantListScreen() {
    val plants = listOf(
        DetailedPlant("Rose", 70, 500),
        DetailedPlant("Cactus", 30, 100),
        DetailedPlant("Tulip", 50, 300)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = "All Plants",
            style = androidx.compose.material3.MaterialTheme.typography.headlineMedium,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(plants) { plant ->
                DetailedPlantCard(plant = plant)
            }
        }
    }
}

@Composable
fun DetailedPlantCard(plant: DetailedPlant) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Plant: ${plant.name}",
                style = androidx.compose.material3.MaterialTheme.typography.bodyLarge
            )
            Text(
                text = "Moisture Level: ${plant.moistureLevel}%",
                style = androidx.compose.material3.MaterialTheme.typography.bodyMedium
            )
            Text(
                text = "Water Requirement: ${plant.waterRequirement} ml/day",
                style = androidx.compose.material3.MaterialTheme.typography.bodyMedium
            )
        }
    }
}