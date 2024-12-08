package com.example.ca3_mobileintegration.ui.theme.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.ca3_mobileintegration.data.model.database.User
import com.example.ca3_mobileintegration.data.model.database.UserDao
import kotlinx.coroutines.launch


@Composable
fun EditProfileScreen(navController: NavHostController, userDao: UserDao, email: String) {
    var userEmail by remember { mutableStateOf(email) }
    var password by remember { mutableStateOf("") }
    var isLoading by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf("") }
    var currentUser by remember { mutableStateOf<User?>(null) }

    val coroutineScope = rememberCoroutineScope()

    // Fetch current user data based on the passed email
    LaunchedEffect(userEmail) {
        val user = userDao.getUserByEmail(userEmail)
        currentUser = user
        if (user != null) {
            password = user.password ?: ""
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Edit Profile", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(16.dp))

        // Email field (non-editable, as email is usually unique and cannot be changed)
        TextField(
            value = userEmail,
            onValueChange = { userEmail = it },
            label = { Text("Email") },
            enabled = false, // Make email field non-editable
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Password field (editable)
        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            modifier = Modifier.fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Update button
        Button(
            onClick = {
                isLoading = true
                errorMessage = ""

                coroutineScope.launch {
                    if (userEmail.isNotEmpty() && password.isNotEmpty()) {
                        val updatedUser = currentUser?.copy(email = userEmail, password = password)
                        try {
                            if (updatedUser != null) {
                                userDao.updateUser(updatedUser)
                                navController.popBackStack() // Navigate back after successful update
                            }
                        } catch (e: Exception) {
                            errorMessage = "Error updating user information"
                        }
                    } else {
                        errorMessage = "Please fill in both email and password"
                    }
                    isLoading = false
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Update Profile")
        }

        Spacer(modifier = Modifier.height(8.dp))

        if (isLoading) {
            CircularProgressIndicator()
        }

        if (errorMessage.isNotEmpty()) {
            Text(text = errorMessage, color = Color.Red)
        }
    }
}