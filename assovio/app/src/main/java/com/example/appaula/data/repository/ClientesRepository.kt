package com.example.appaula.data.repository

import com.example.appaula.data.model.Cliente
import kotlinx.coroutines.flow.Flow

interface ClientesRepository {
    fun getAllClientesStream(): Flow<List<Cliente>>
    fun getClientesStream(id: Int): Flow<Cliente?>
    suspend fun insertCliente(cliente: Cliente)
    suspend fun updateCliente(cliente: Cliente)
    suspend fun deleteCliente(cliente: Cliente)
}
