package com.example.platepal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.example.platepal.ui.navigation.NavGraph
import com.example.platepal.ui.theme.PlatePalTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PlatePalTheme {
                val navController = rememberNavController()
                NavGraph(navController = navController)
            }
        }
    }
}