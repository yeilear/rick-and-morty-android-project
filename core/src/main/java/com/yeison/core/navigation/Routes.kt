package com.yeison.core.navigation

sealed class Routes(val route: String) {
    data object Splash : Routes("splash")
    data object Home : Routes("home")
}