package com.example.ca3_mobileintegration

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.ca3_mobileintegration.data.model.database.AppDatabase
import com.example.ca3_mobileintegration.data.model.database.UserDao
import com.example.ca3_mobileintegration.navigation.AppNavigation
import com.example.ca3_mobileintegration.ui.theme.screens.RegistrationScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val db = AppDatabase.getDatabase(applicationContext)
        val userDao = db.userDao()

        setContent {
            // Pass userDao to the RegistrationScreen
//            RegistrationScreen(userDao = userDao)
            MainAppContent(userDao = userDao)
        }
    }
}

@Composable
fun MainAppContent(userDao: UserDao) {
    // Create a NavController for managing screen navigation
    val navController = rememberNavController()

    // Pass the userDao to AppNavigation
    AppNavigation(navController = navController, userDao = userDao)
}