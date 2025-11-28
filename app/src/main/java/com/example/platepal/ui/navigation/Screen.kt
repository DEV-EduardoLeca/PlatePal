package com.example.platepal.ui.navigation

sealed class Screen(val route: String) {
    data object Home : Screen("home")
    data object Details : Screen("details")
    data object Profile : Screen("profile")
}
