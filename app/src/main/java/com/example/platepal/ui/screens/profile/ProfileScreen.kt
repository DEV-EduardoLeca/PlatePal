package com.example.platepal.ui.screens.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.platepal.ui.components.PlatePalBottomNavigationBar
import com.example.platepal.ui.theme.CoralBackground
import com.example.platepal.ui.theme.CoralDark

@Composable
fun ProfileScreen(
    onNavigateToHome: () -> Unit,
    onNavigateToFavorites: () -> Unit,
    onNavigateToAddRecipe: () -> Unit,
    onLogout: () -> Unit
) {
    var selectedBottomNavIndex by remember { mutableIntStateOf(3) } // Perfil selecionado

    Scaffold(
        bottomBar = {
            PlatePalBottomNavigationBar(
                selectedIndex = selectedBottomNavIndex,
                onItemSelected = { index ->
                    selectedBottomNavIndex = index
                    when (index) {
                        0 -> onNavigateToHome() // Home
                        1 -> onNavigateToFavorites() // Favoritos
                        2 -> onNavigateToAddRecipe() // Adicionar Receita
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
                .padding(horizontal = 24.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(24.dp))
            // Botão de voltar no topo direito
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(modifier = Modifier.width(48.dp))

                // Ícone de planta centralizado
                Text(
                    text = "🌱",
                    fontSize = 40.sp
                )

                // Botão de voltar
                Box(
                    modifier = Modifier
                        .size(48.dp)
                        .clip(CircleShape)
                        .background(Color(0xFF8B5A5A))
                        .clickable { onNavigateToHome() },
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Voltar",
                        tint = Color.White,
                        modifier = Modifier.size(24.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(32.dp))

            // Avatar do usuário
            Box(
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape)
                    .background(Color.White)
                    .border(4.dp, Color.White, CircleShape),
                contentAlignment = Alignment.Center
            ) {
                // Aqui você pode adicionar uma imagem real do usuário
                // Por enquanto, vou usar um círculo com as iniciais
                Text(
                    text = "👤",
                    fontSize = 60.sp
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Nome do usuário
            Text(
                text = "Marcio_22",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(32.dp))

            // Menu de opções
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                ProfileMenuItem(
                    text = "Informações Pessoais",
                    onClick = { /* TODO */ }
                )

                ProfileMenuItem(
                    text = "Configurações",
                    onClick = { /* TODO */ }
                )

                ProfileMenuItem(
                    text = "Acessibilidade",
                    onClick = { /* TODO */ }
                )

                ProfileMenuItem(
                    text = "Termos e Condições",
                    onClick = { /* TODO */ }
                )

                ProfileMenuItem(
                    text = "Cancelar Conta",
                    onClick = { /* TODO */ }
                )
            }

            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

@Composable
private fun ProfileMenuItem(
    text: String,
    onClick: () -> Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(28.dp),
        color = Color.White.copy(alpha = 0.9f)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = text,
                fontSize = 16.sp,
                color = Color(0xFF5A3A3A),
                fontWeight = FontWeight.Medium
            )

            Icon(
                imageVector = Icons.Default.KeyboardArrowRight,
                contentDescription = "Ir para $text",
                tint = Color(0xFF5A3A3A)
            )
        }
    }
}
