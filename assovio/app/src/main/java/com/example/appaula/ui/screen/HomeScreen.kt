package com.example.appaula.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.appaula.ui.components.TopBar
import com.example.appaula.ui.components.defaults.DefaultButton
import kotlinx.serialization.Serializable

@Serializable
object HomeScreen

@Composable
fun HomeScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        TopBar(
            title = "Aplicativo Empresa"
        )

        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Column {

            }

            DefaultButton(
                modifier = Modifier
                    .padding(end = 24.dp, bottom = 24.dp)
                    .height(52.dp)
                    .align(alignment = Alignment.BottomEnd)
                    .aspectRatio(1f),

                onClick = {
                    navController.navigate(InsertScreen)
                }
            ) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = "Cadastrar cliente"
                )
            }
        }
    }
}
