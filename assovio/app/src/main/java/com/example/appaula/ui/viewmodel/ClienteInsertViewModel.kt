package com.example.appaula.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.appaula.data.model.ClienteState
import com.example.appaula.data.model.toCliente
import com.example.appaula.data.repository.ClientesRepository

// Classe que armazena as informações/States para a View ou Fragment e cuida da lógica das regras de negócio
class ClienteInsertViewModel(private val clientesRepository: ClientesRepository) : ViewModel() {
    // Estado armazenado pelo ViewModel
    var clienteState by mutableStateOf(ClienteState())
        private set

    // Funções para a View se comunicar com os dados
    
    // Atualiza o estado do cliente dentro da classe
    // Semelhante ao Setter
    fun updateUiState(clienteUiState: ClienteState) {
        clienteState = clienteUiState
    }

    // Salva o estado do cliente no banco de dados através do repositório
    suspend fun saveCliente(): Boolean {
        if (!verifySaveable()) {
            return false
        }

        clientesRepository.insertCliente(clienteState.toCliente())
        return true
    }

    // Verifica se o estado atual segue as regras necessárias
    fun verifySaveable(): Boolean {
        return clienteState.nome !== ""
    }
}
