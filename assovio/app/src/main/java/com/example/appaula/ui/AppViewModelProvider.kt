package com.example.appaula.ui

import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.appaula.EmpresaApplication
import com.example.appaula.ui.viewmodel.ClienteInsertViewModel

// Provider/Provedor de ViewModels para a aplicação através de Factory
// Factory é padronizar a inicialização de uma ou mais classes
// Ajuda no controle de dependencias ao centralizar as inicializações
object AppViewModelProvider {
    val Factory = viewModelFactory {
        initializer {
            ClienteInsertViewModel(empresaApplication().container.clientesRepository)
        }
    }
}

// Função para instanciar a classe da aplicação
fun CreationExtras.empresaApplication(): EmpresaApplication =
    (this[AndroidViewModelFactory.APPLICATION_KEY] as EmpresaApplication)
