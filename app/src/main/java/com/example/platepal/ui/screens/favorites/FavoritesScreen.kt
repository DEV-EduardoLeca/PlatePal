package com.example.platepal.ui.screens.favorites

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
import com.example.platepal.ui.components.PlatePalBottomNavigationBar
import com.example.platepal.ui.components.Recipe
import com.example.platepal.ui.components.RecipeCard
import com.example.platepal.ui.theme.CoralBackground

@Composable
fun FavoritesScreen(
    onNavigateToHome: () -> Unit,
    onNavigateToDetails: () -> Unit,
    onNavigateToAddRecipe: () -> Unit,
    onNavigateToProfile: () -> Unit,
    onLogout: () -> Unit
) {
    var selectedBottomNavIndex by remember { mutableIntStateOf(1) } // Favoritos selecionado

    // Lista de receitas favoritas (simulada - depois pode vir de um ViewModel/Database)
    val favoriteRecipes = listOf(
        Recipe(
            name = "Francesinha vegan",
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
            name = "Salada Caesar",
            difficulty = "Fácil",
            time = "15Min",
            rating = 5,
            calories = 300
        )
    )

    Scaffold(
        bottomBar = {
            PlatePalBottomNavigationBar(
                selectedIndex = selectedBottomNavIndex,
                onItemSelected = { index ->
                    selectedBottomNavIndex = index
                    when (index) {
                        0 -> onNavigateToHome() // Home
                        2 -> onNavigateToAddRecipe() // Adicionar Receita
                        3 -> onNavigateToProfile() // Perfil
                        4 -> onLogout() // Logout
                    }
                }
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
            // Ícone de planta
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

            // Título
            item {
                Text(
                    text = "Minhas Receitas Favoritas",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier.padding(top = 8.dp)
                )
            }

            // Verificar se há favoritos
            if (favoriteRecipes.isEmpty()) {
                item {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 48.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.spacedBy(16.dp)
                        ) {
                            Text(
                                text = "❤️",
                                fontSize = 64.sp
                            )
                            Text(
                                text = "Nenhuma receita favorita ainda",
                                fontSize = 18.sp,
                                color = Color.White,
                                fontWeight = FontWeight.Medium
                            )
                            Text(
                                text = "Adicione receitas aos favoritos para vê-las aqui",
                                fontSize = 14.sp,
                                color = Color.White.copy(alpha = 0.7f)
                            )
                        }
                    }
                }
            } else {
                // Cards de receitas favoritas
                items(favoriteRecipes) { recipe ->
                    RecipeCard(
                        recipe = recipe,
                        onClick = onNavigateToDetails
                    )
                }
            }

            // Bottom padding
            item {
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}
