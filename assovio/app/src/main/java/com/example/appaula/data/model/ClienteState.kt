package com.example.appaula.data.model

data class ClienteState(
    var id: Int = 0,
    var nome: String = "",
    var endereco: String = "",
    var bairro: String = "",
    var cep: String = "",
    var cidade: String = "",
    var estado: String = ""
)

fun ClienteState.toCliente(): Cliente = Cliente(
    id = id,
    nome = nome,
    endereco = endereco,
    bairro = bairro,
    cep = cep,
    cidade = cidade,
    estado = estado
)
