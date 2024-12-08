package com.example.ca3_mobileintegration.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.ca3_mobileintegration.data.model.database.UserDao
import com.example.ca3_mobileintegration.ui.theme.screens.AddPlantScreen
import com.example.ca3_mobileintegration.ui.theme.screens.HomeScreen
import com.example.ca3_mobileintegration.ui.theme.screens.LoginScreen
import com.example.ca3_mobileintegration.ui.theme.screens.PlantListScreen
import com.example.ca3_mobileintegration.ui.theme.screens.RegistrationScreen

sealed class Screen(val route: String) {
    object Login : Screen("login")
    object Home : Screen("home")
    object AddPlant : Screen("add_plant")
    object Registration : Screen("registration")
    object PlantList : Screen("plant_list")
}

@Composable
fun AppNavigation(navController: NavHostController, userDao: UserDao) {
    NavHost(navController = navController, startDestination = Screen.Login.route) {
        composable(Screen.Login.route) {
            LoginScreen(navController,userDao)
        }
        composable(Screen.Home.route) {
            HomeScreen(navController)
        }
        composable(Screen.AddPlant.route) {
            AddPlantScreen(navController)
        }
        composable(Screen.Registration.route) {
            RegistrationScreen(navController, userDao) // Pass the navController and userDao
        }
        composable(Screen.PlantList.route) {
            PlantListScreen()
        }
    }
}


