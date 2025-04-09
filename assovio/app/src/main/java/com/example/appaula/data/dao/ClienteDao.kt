package com.example.appaula.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.appaula.data.model.Cliente
import kotlinx.coroutines.flow.Flow

@Dao
interface ClienteDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(cliente: Cliente)

    @Update
    suspend fun update(cliente: Cliente)

    @Delete
    suspend fun delete(cliente: Cliente)

    @Query("SELECT * from clientes WHERE id = :id")
    fun getCliente(id: Int): Flow<Cliente>

    @Query("SELECT * from clientes ORDER BY id ASC")
    fun getAllClientes(): Flow<List<Cliente>>
}
