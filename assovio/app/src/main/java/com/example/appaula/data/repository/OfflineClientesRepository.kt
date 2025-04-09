package com.example.appaula.data.repository

import com.example.appaula.data.dao.ClienteDao
import com.example.appaula.data.model.Cliente
import kotlinx.coroutines.flow.Flow

class OfflineClientesRepository(private val clienteDao: ClienteDao) : ClientesRepository {
    override fun getAllClientesStream(): Flow<List<Cliente>> = clienteDao.getAllClientes()
    override fun getClientesStream(id: Int): Flow<Cliente?> = clienteDao.getCliente(id)
    override suspend fun insertCliente(cliente: Cliente) = clienteDao.insert(cliente)
    override suspend fun updateCliente(cliente: Cliente) = clienteDao.update(cliente)
    override suspend fun deleteCliente(cliente: Cliente) = clienteDao.delete(cliente)
}
