package com.example.ca3_mobileintegration.ui.theme.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavHostController
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.ca3_mobileintegration.ViewModel.HomeViewModel
import com.example.ca3_mobileintegration.ViewModel.HomeViewModelFactory
import com.example.ca3_mobileintegration.data.model.database.AppDatabase
import com.example.ca3_mobileintegration.navigation.Screen

// Sample data class representing a plant
data class Plant(val name: String, val moistureLevel: Int)

@Composable
fun HomeScreen(navController: NavHostController,email: String,name: String) {
    val plants = listOf(
        Plant("Rose", 70),
        Plant("Cactus", 30),
        Plant("Tulip", 50)
    )
//    val userEmail = "user@example.com"
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Welcome, $name!", style = MaterialTheme.typography.headlineMedium)
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "My Plants",
            style = androidx.compose.material3.MaterialTheme.typography.headlineMedium,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(plants) { plant ->
                PlantCard(plant = plant)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { navController.navigate(Screen.AddPlant.route) },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(text = "Add New Plant")
        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = { navController.navigate(Screen.PlantList.route) },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(text = "View All Plants")
        }
        Button(onClick = {
            navController.navigate("edit_profile/$email") // Pass email as part of the route
        }) {
            Text(text = "Edit Profile")
        }
    }
}

@Composable
fun PlantCard(plant: Plant) {
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
        }
    }
}

