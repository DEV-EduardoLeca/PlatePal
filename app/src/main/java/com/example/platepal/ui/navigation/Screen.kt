package com.example.platepal.ui.navigation

sealed class Screen(val route: String) {
    data object Login : Screen("login")
    data object Register : Screen("register")
    data object Home : Screen("home")
    data object Details : Screen("details")
    data object Profile : Screen("profile")
    data object AddRecipe : Screen("add_recipe")
    data object Favorites : Screen("favorites")
}
