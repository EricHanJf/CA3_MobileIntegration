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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.ca3_mobileintegration.navigation.Screen
import androidx.navigation.NavHostController

// Updated data class with an imageUrl property
data class Plant(val name: String, val moistureLevel: Int, val imageUrl: String)

@Composable
fun HomeScreen(navController: NavHostController, email: String) {
    // List of plants with their images
    val plants = listOf(
        Plant("Rose", 70, "https://i.pinimg.com/736x/06/54/7a/06547a402611c9e9157175f37f329823.jpg"),
        Plant("Cactus", 30, "https://www.gardens4you.ie/media/catalog/product/cache/6d6e270e1eef6d7aa204aa65622d8cce/f/d/fd15680wh.jpg"),
        Plant("Tulip", 50, "https://storage.googleapis.com/pod_public/1300/202829.jpg"),
        Plant("Sunflower", 70, "https://media.interflora.ie/i/interflora/tall-sunflowers-yellow-skyscraper")
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Hydrabloom",
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

        Button(
            onClick = { navController.navigate("edit_profile/$email") }, // Pass email as part of the route
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
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
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            // Load image using Coil
            AsyncImage(
                model = plant.imageUrl,
                contentDescription = "Image of ${plant.name}",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
            )
            Text(
                text = "Plant: ${plant.name}",
                style = androidx.compose.material3.MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Start
            )
            Text(
                text = "Moisture Level: ${plant.moistureLevel}%",
                style = androidx.compose.material3.MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Start
            )
        }
    }
}
