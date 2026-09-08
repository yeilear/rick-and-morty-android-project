package com.yeison.rick_and_morty.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.yeison.core.navigation.Routes
import com.yeison.rick_and_morty.ui.component.SplashComponent

@Composable
fun SplashScreen(
    navController: NavController,
    splashViewModel: SplashViewModel = hiltViewModel()
) {
    val destination by splashViewModel.destination.collectAsState()

    LaunchedEffect(destination) {
        destination?.let { route ->
            navController.navigate(route) {
                popUpTo(Routes.Splash.route) { inclusive = true }
            }
        }
    }

    SplashComponent(
        onTimeout = splashViewModel::onTimeout
    )
}
