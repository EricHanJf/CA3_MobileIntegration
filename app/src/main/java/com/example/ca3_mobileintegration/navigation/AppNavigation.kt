package com.example.ca3_mobileintegration.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.ca3_mobileintegration.data.model.database.UserDao
import com.example.ca3_mobileintegration.ui.theme.screens.AddPlantScreen
import com.example.ca3_mobileintegration.ui.theme.screens.EditProfileScreen
import com.example.ca3_mobileintegration.ui.theme.screens.HomeScreen
import com.example.ca3_mobileintegration.ui.theme.screens.LoginScreen
import com.example.ca3_mobileintegration.ui.theme.screens.PlantListScreen
import com.example.ca3_mobileintegration.ui.theme.screens.RegistrationScreen

sealed class Screen(val route: String) {
    object Login : Screen("login")
    object Home : Screen("home/{email}")
    object AddPlant : Screen("add_plant")
    object Registration : Screen("registration")
    object PlantList : Screen("plant_list")
    object EditProfile : Screen("edit_profile/{email}")
}

@Composable
fun AppNavigation(navController: NavHostController, userDao: UserDao) {
    NavHost(navController = navController, startDestination = Screen.Login.route) {
        composable(Screen.Login.route) {
            LoginScreen(navController,userDao)
        }
//        composable(Screen.Home.route) {
//            HomeScreen(navController)
//        }
        composable("home/{email}") { backStackEntry ->
            val email = backStackEntry.arguments?.getString("email") ?: ""
            HomeScreen(navController, email) // Pass the email to HomeScreen
        }


//        composable(Screen.Home.route) {
//            val userId = 1 // Retrieve this value from your authentication system
//            HomeScreen(navController = navController, userId = userId)
//        }
        composable(Screen.AddPlant.route) {
            AddPlantScreen(navController)
        }
        composable(Screen.Registration.route) {
            RegistrationScreen(navController, userDao) // Pass the navController and userDao
        }
        composable(Screen.PlantList.route) {
            PlantListScreen()
        }
//        composable(Screen.EditProfile.route) {
//            EditProfileScreen(navController, userDao)
//        }
        composable("edit_profile/{email}") { backStackEntry ->
            val email = backStackEntry.arguments?.getString("email") ?: ""
            EditProfileScreen(navController, userDao, email)
        }

    }
}


