package com.example.appaula.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "clientes")
data class Cliente(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val nome: String,
    val endereco: String,
    val bairro: String,
    val cep: String,
    val cidade: String,
    val estado: String
)
