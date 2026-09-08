package com.yeison.rick_and_morty

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.yeison.core.navigation.AppNavHost
import com.yeison.core.navigation.Routes
import com.yeison.core.theme.RickAndMortyTheme
import com.yeison.rick_and_morty.app.ui.screen.HomeScreen
import com.yeison.rick_and_morty.ui.screens.splash.SplashScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RickAndMortyTheme {
                val currentNavController = rememberNavController()

                AppNavHost(
                    navController = currentNavController,
                    startDestination = Routes.Splash.route
                ) {
                    composable(Routes.Splash.route) {
                        SplashScreen(navController = currentNavController)
                    }

                    composable(route = Routes.Home.route) {
                        HomeScreen()
                    }
                }
            }
        }
    }
}