package com.example.appaula.ui.components.insert_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.appaula.ui.components.defaults.TextInput
import com.example.appaula.ui.viewmodel.ClienteInsertViewModel

@Composable
fun FormFields(
    modifier: Modifier = Modifier,
    viewModel: ClienteInsertViewModel
) {
    Column(
        modifier = modifier
    ) {
        TextInput(
            value = viewModel.clienteState.nome,
            onValueChange = {
                viewModel.updateUiState(viewModel.clienteState.copy(nome = it))
            },
            "Nome"
        )
        TextInput(
            value = viewModel.clienteState.endereco,
            onValueChange = {
                viewModel.updateUiState(viewModel.clienteState.copy(endereco = it))
            },
            "Endereço"
        )
        TextInput(
            value = viewModel.clienteState.bairro,
            onValueChange = {
                viewModel.updateUiState(viewModel.clienteState.copy(bairro = it))
            },
            "Bairro"
        )
        TextInput(
            value = viewModel.clienteState.cep,
            onValueChange = {
                viewModel.updateUiState(viewModel.clienteState.copy(cep = it))
            },
            "CEP"
        )
        TextInput(
            value = viewModel.clienteState.cidade,
            onValueChange = {
                viewModel.updateUiState(viewModel.clienteState.copy(cidade = it))
            },
            "Cidade"
        )
        TextInput(
            value = viewModel.clienteState.estado,
            onValueChange = {
                viewModel.updateUiState(viewModel.clienteState.copy(estado = it))
            },
            "Estado"
        )
    }
}
