package com.example.appaula.ui.components.insert_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.appaula.data.model.ClienteState
import com.example.appaula.ui.AppViewModelProvider
import com.example.appaula.ui.components.defaults.DefaultButton
import com.example.appaula.ui.viewmodel.ClienteInsertViewModel
import kotlinx.coroutines.launch

@Composable
fun InsertForm(
    modifier: Modifier = Modifier,
    viewModel: ClienteInsertViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {
    val coroutineScope = rememberCoroutineScope()
    val focusManager = LocalFocusManager.current

    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Title
        Text(
            text = "Preencha os dados",
            fontSize = 24.sp
        )

        // Body
        FormFields(
            modifier = Modifier.weight(1f),
            viewModel = viewModel
        )

        // Submit
        DefaultButton(
            onClick = {
                focusManager.clearFocus()

                coroutineScope.launch {
                    if (viewModel.saveCliente()) {
                        // If saved, clear form
                        viewModel.updateUiState(ClienteState())
                    }
                }
            },
            contentPadding = PaddingValues(horizontal = 24.dp, vertical = 8.dp)
        ) {
            Text(
                text = "Cadastrar",
                fontSize = 24.sp,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
    }
}
