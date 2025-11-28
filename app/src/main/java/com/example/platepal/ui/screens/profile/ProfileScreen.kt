package com.example.platepal.ui.screens.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.platepal.ui.components.PlatePalButton
import com.example.platepal.ui.components.PlatePalCard
import com.example.platepal.ui.components.PlatePalTextField
import com.example.platepal.ui.components.PlatePalTopBar

@Composable
fun ProfileScreen(
    onNavigateBack: () -> Unit
) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            PlatePalTopBar(
                title = "Perfil",
                onNavigationClick = onNavigateBack
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                Text(
                    text = "Informações Pessoais",
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold
                )
            }

            item {
                PlatePalCard {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        PlatePalTextField(
                            value = name,
                            onValueChange = { name = it },
                            label = "Nome",
                            placeholder = "Digite seu nome"
                        )

                        PlatePalTextField(
                            value = email,
                            onValueChange = { email = it },
                            label = "Email",
                            placeholder = "Digite seu email"
                        )
                    }
                }
            }

            item {
                PlatePalCard {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(
                            text = "Estatísticas",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                        StatItem("Receitas Favoritas", "0")
                        StatItem("Receitas Criadas", "0")
                        StatItem("Tempo Total de Cozinha", "0h")
                    }
                }
            }

            item {
                PlatePalButton(
                    text = "Salvar Alterações",
                    onClick = { }
                )
            }

            item {
                PlatePalButton(
                    text = "Sair",
                    onClick = { },
                    backgroundColor = MaterialTheme.colorScheme.error
                )
            }
        }
    }
}

@Composable
private fun StatItem(label: String, value: String) {
    Column(
        modifier = Modifier.padding(vertical = 8.dp)
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Text(
            text = value,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.SemiBold
        )
    }
}
