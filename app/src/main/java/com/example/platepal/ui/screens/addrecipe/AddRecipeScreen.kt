package com.example.platepal.ui.screens.addrecipe

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.platepal.ui.components.PlatePalBottomNavigationBar
import com.example.platepal.ui.theme.BeigeCream
import com.example.platepal.ui.theme.CoralBackground
import com.example.platepal.ui.theme.CoralDark

@Composable
fun AddRecipeScreen(
    onNavigateToHome: () -> Unit,
    onNavigateToFavorites: () -> Unit,
    onNavigateToProfile: () -> Unit,
    onLogout: () -> Unit
) {
    var selectedBottomNavIndex by remember { mutableIntStateOf(2) } // Add selecionado
    var recipeTitle by remember { mutableStateOf("") }
    var difficulty by remember { mutableStateOf("Médio") }
    var isFacil by remember { mutableStateOf(false) }
    var isMedio by remember { mutableStateOf(true) }
    var isDificil by remember { mutableStateOf(false) }
    var timeMinutes by remember { mutableStateOf("15") }
    var calories by remember { mutableStateOf("2300") }
    var ingredients by remember { mutableStateOf("") }
    var preparationSteps by remember { mutableStateOf("") }

    Scaffold(
        bottomBar = {
            PlatePalBottomNavigationBar(
                selectedIndex = selectedBottomNavIndex,
                onItemSelected = { index ->
                    selectedBottomNavIndex = index
                    when (index) {
                        0 -> onNavigateToHome() // Home
                        1 -> onNavigateToFavorites() // Favoritos
                        3 -> onNavigateToProfile() // Perfil
                        4 -> onLogout() // Logout
                    }
                }
            )
        },
        containerColor = CoralBackground
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(CoralBackground)
                .padding(paddingValues)
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Ícone de planta no topo
            Text(
                text = "🌱",
                fontSize = 40.sp,
                modifier = Modifier.padding(vertical = 16.dp)
            )

            // Área de adicionar foto
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(140.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(BeigeCream)
                    .clickable { /* TODO: Adicionar foto */ },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Adicionar Foto",
                    fontSize = 16.sp,
                    color = Color(0xFF5A3A3A)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Dificuldade e Radio Buttons
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.Warning,
                        contentDescription = "Dificuldade",
                        tint = Color(0xFF5A3A3A),
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "Dificuldade : ",
                        fontSize = 14.sp,
                        color = Color(0xFF5A3A3A)
                    )
                }

                // Radio buttons
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RadioButtonWithLabel(
                        selected = isFacil,
                        onClick = {
                            isFacil = true
                            isMedio = false
                            isDificil = false
                            difficulty = "Fácil"
                        },
                        label = "Fácil"
                    )
                    RadioButtonWithLabel(
                        selected = isMedio,
                        onClick = {
                            isFacil = false
                            isMedio = true
                            isDificil = false
                            difficulty = "Médio"
                        },
                        label = "Médio"
                    )
                    RadioButtonWithLabel(
                        selected = isDificil,
                        onClick = {
                            isFacil = false
                            isMedio = false
                            isDificil = true
                            difficulty = "Difícil"
                        },
                        label = "Difícil"
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Tempo e Kcal
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Tempo
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.DateRange,
                        contentDescription = "Tempo",
                        tint = Color(0xFF5A3A3A),
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "Tempo : ",
                        fontSize = 14.sp,
                        color = Color(0xFF5A3A3A)
                    )
                    Box(
                        modifier = Modifier
                            .width(50.dp)
                            .height(30.dp)
                            .border(1.dp, Color(0xFF5A3A3A), RoundedCornerShape(4.dp))
                            .padding(4.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        BasicTextField(
                            value = timeMinutes,
                            onValueChange = { timeMinutes = it },
                            textStyle = TextStyle(
                                fontSize = 14.sp,
                                color = Color(0xFF5A3A3A)
                            ),
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "min",
                        fontSize = 14.sp,
                        color = Color(0xFF5A3A3A)
                    )
                }

                Spacer(modifier = Modifier.width(16.dp))

                // Kcal
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "🔥",
                        fontSize = 16.sp
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "Kcal : ",
                        fontSize = 14.sp,
                        color = Color(0xFF5A3A3A)
                    )
                    Box(
                        modifier = Modifier
                            .width(60.dp)
                            .height(30.dp)
                            .border(1.dp, Color(0xFF5A3A3A), RoundedCornerShape(4.dp))
                            .padding(4.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        BasicTextField(
                            value = calories,
                            onValueChange = { calories = it },
                            textStyle = TextStyle(
                                fontSize = 14.sp,
                                color = Color(0xFF5A3A3A)
                            ),
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "Kcal",
                        fontSize = 14.sp,
                        color = Color(0xFF5A3A3A)
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Título da receita
            OutlinedTextField(
                value = recipeTitle,
                onValueChange = { recipeTitle = it },
                placeholder = { Text("Título da receita", color = Color(0xFF5A3A3A)) },
                modifier = Modifier
                    .fillMaxWidth()
                    .border(2.dp, Color(0xFF5A3A3A), RoundedCornerShape(8.dp)),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedContainerColor = Color.Transparent,
                    focusedContainerColor = Color.Transparent,
                    unfocusedBorderColor = Color.Transparent,
                    focusedBorderColor = Color.Transparent
                ),
                textStyle = TextStyle(
                    fontSize = 16.sp,
                    color = Color(0xFF5A3A3A)
                ),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Ingredientes
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp))
                    .background(CoralDark)
                    .padding(16.dp)
            ) {
                Text(
                    text = "Ingredientes",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF5A3A3A),
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                OutlinedTextField(
                    value = ingredients,
                    onValueChange = { ingredients = it },
                    placeholder = { Text("Adicionar", color = Color(0xFF5A3A3A).copy(alpha = 0.6f)) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedContainerColor = CoralDark,
                        focusedContainerColor = CoralDark,
                        unfocusedBorderColor = Color.Transparent,
                        focusedBorderColor = Color.Transparent
                    ),
                    textStyle = TextStyle(
                        fontSize = 14.sp,
                        color = Color(0xFF5A3A3A)
                    )
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Modo de Preparo
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp))
                    .background(CoralDark)
                    .padding(16.dp)
            ) {
                Text(
                    text = "Modo de Preparo",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF5A3A3A),
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(bottom = 8.dp)
                ) {
                    Text(
                        text = "1 - ",
                        fontSize = 14.sp,
                        color = Color(0xFF5A3A3A),
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Adicionar",
                        fontSize = 14.sp,
                        color = Color(0xFF5A3A3A).copy(alpha = 0.6f)
                    )
                }

                OutlinedTextField(
                    value = preparationSteps,
                    onValueChange = { preparationSteps = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedContainerColor = CoralDark,
                        focusedContainerColor = CoralDark,
                        unfocusedBorderColor = Color.Transparent,
                        focusedBorderColor = Color.Transparent
                    ),
                    textStyle = TextStyle(
                        fontSize = 14.sp,
                        color = Color(0xFF5A3A3A)
                    )
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Botão Adicionar discreto
            Button(
                onClick = { /* TODO: Salvar receita */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF5A3A3A).copy(alpha = 0.7f)
                ),
                shape = RoundedCornerShape(24.dp)
            ) {
                Text(
                    text = "Adicionar",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.White
                )
            }

            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

@Composable
private fun RadioButtonWithLabel(
    selected: Boolean,
    onClick: () -> Unit,
    label: String
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.clickable { onClick() }
    ) {
        RadioButton(
            selected = selected,
            onClick = onClick,
            colors = RadioButtonDefaults.colors(
                selectedColor = Color(0xFF5A3A3A),
                unselectedColor = Color(0xFF5A3A3A)
            ),
            modifier = Modifier.size(20.dp)
        )
        Text(
            text = label,
            fontSize = 12.sp,
            color = Color(0xFF5A3A3A),
            modifier = Modifier.padding(end = 8.dp)
        )
    }
}
