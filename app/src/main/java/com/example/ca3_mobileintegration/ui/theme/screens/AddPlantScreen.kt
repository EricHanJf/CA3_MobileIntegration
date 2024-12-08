package com.example.ca3_mobileintegration.ui.theme.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.navigation.NavHostController
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.ca3_mobileintegration.navigation.Screen

@Composable
fun AddPlantScreen(navController: NavHostController) {
    // State variables for plant details
    var plantName by remember { mutableStateOf("") }
    var temperature by remember { mutableStateOf("") }
    var humidity by remember { mutableStateOf("") }
    var location by remember { mutableStateOf("") }
    var waterRequirement by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Add New Plant",
            style = androidx.compose.material3.MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = plantName,
            onValueChange = { plantName = it },
            label = { Text("Plant Name") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = temperature,
            onValueChange = { temperature = it },
            label = { Text("Preferred Temperature (°C)") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = humidity,
            onValueChange = { humidity = it },
            label = { Text("Preferred Humidity (%)") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = location,
            onValueChange = { location = it },
            label = { Text("Location") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = waterRequirement,
            onValueChange = { waterRequirement = it },
            label = { Text("Water Requirement (ml/day)") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                // Handle adding the plant to the database
                // Navigate back to the Plant List or Home screen
                navController.navigate(Screen.PlantList.route)
            }
        ) {
            Text(text = "Save Plant")
        }
    }
}
