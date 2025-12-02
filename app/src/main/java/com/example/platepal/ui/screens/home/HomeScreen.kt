package com.example.platepal.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.platepal.ui.components.CategoryButton
import com.example.platepal.ui.components.PlatePalBottomNavigationBar
import com.example.platepal.ui.components.PlatePalSearchBar
import com.example.platepal.ui.components.Recipe
import com.example.platepal.ui.components.RecipeCard
import com.example.platepal.ui.theme.CoralBackground

@Composable
fun HomeScreen(
    onNavigateToDetails: () -> Unit,
    @Suppress("UNUSED_PARAMETER")
    onNavigateToProfile: () -> Unit
) {
    var selectedBottomNavIndex by remember { mutableIntStateOf(0) }

    val recipes = listOf(
        Recipe(
            name = "Frango assado",
            difficulty = "Médio",
            time = "25Min",
            rating = 5,
            calories = 450
        ),
        Recipe(
            name = "Peixe assado",
            difficulty = "Médio",
            time = "20Min",
            rating = 4,
            calories = 400
        ),
        Recipe(
            name = "Carne assada",
            difficulty = "Médio",
            time = "30Min",
            rating = 5,
            calories = 500
        )
    )

    Scaffold(
        bottomBar = {
            PlatePalBottomNavigationBar(
                selectedIndex = selectedBottomNavIndex,
                onItemSelected = { selectedBottomNavIndex = it }
            )
        },
        containerColor = CoralBackground
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(CoralBackground)
                .padding(paddingValues),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Plant Icon
            item {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "🌱",
                        fontSize = 48.sp
                    )
                }
            }

            // Search Bar
            item {
                PlatePalSearchBar(
                    placeholder = "Pesquisa",
                    onMicClick = { /* Handle mic click */ }
                )
            }

            // Category Buttons
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    CategoryButton(
                        text = "Carne",
                        emoji = "🥩",
                        onClick = { /* Handle category click */ }
                    )
                    CategoryButton(
                        text = "Peixe",
                        emoji = "🐟",
                        onClick = { /* Handle category click */ }
                    )
                    CategoryButton(
                        text = "Frango",
                        emoji = "🍗",
                        onClick = { /* Handle category click */ }
                    )
                }
            }

            // Title
            item {
                Text(
                    text = "Top 10 Receitas da Semana",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier.padding(top = 8.dp)
                )
            }

            // Recipe Cards
            items(recipes) { recipe ->
                RecipeCard(
                    recipe = recipe,
                    onClick = onNavigateToDetails
                )
            }

            // Bottom padding
            item {
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}
