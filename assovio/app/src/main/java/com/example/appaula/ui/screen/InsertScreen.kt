package com.example.appaula.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.appaula.ui.components.TopBar
import com.example.appaula.ui.components.insert_screen.InsertForm
import kotlinx.serialization.Serializable

@Serializable
object InsertScreen

@Composable
fun InsertScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        TopBar(
            title = "Cadastro de Clientes",
            onClickBack = {
                navController.popBackStack()
            }
        )

        InsertForm(
            modifier = Modifier.padding(vertical = 16.dp)
        )
    }
}
