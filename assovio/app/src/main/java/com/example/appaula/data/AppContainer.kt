package com.example.appaula.data

import android.content.Context
import com.example.appaula.data.database.EmpresaDatabase
import com.example.appaula.data.repository.ClientesRepository
import com.example.appaula.data.repository.OfflineClientesRepository

interface AppContainer {
    val clientesRepository: ClientesRepository
}

class AppDataContainer(private val context: Context) : AppContainer {
    override val clientesRepository: ClientesRepository by lazy {
        OfflineClientesRepository(EmpresaDatabase.getDatabase(context).clienteDao())
    }
}
