package com.example.appaula.navigation

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.navigation.compose.composable
import com.example.appaula.ui.screen.HomeScreen
import com.example.appaula.ui.screen.InsertScreen

@Composable
fun AppRoot() {
    val focusManager = LocalFocusManager.current

    // Wrapper (Scaffold)
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .pointerInput(Unit) {
                detectTapGestures(
                    onTap = { focusManager.clearFocus() }
                )
            },
        containerColor = Color.White
    ) { innerPadding ->
        // Navigation (Graph)
        AppNavigation { navController ->
            composable<HomeScreen> {
                HomeScreen(
                    modifier = Modifier.padding(innerPadding),
                    navController = navController
                )
            }
            composable<InsertScreen> {
                InsertScreen(
                    modifier = Modifier.padding(innerPadding),
                    navController = navController
                )
            }
        }
    }
}
