package com.example.fogobase

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fogobase.ui.theme.FogoBaseTheme
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FogoBaseTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    fogoBase()
                }
            }
        }
    }
}

@Composable
fun fogoBase() {
    var nome by remember { mutableStateOf("") }
    var sobre by remember { mutableStateOf("") }
    var tel by remember { mutableStateOf("") }
    var idade by remember { mutableStateOf("") }

    var dados by remember { mutableStateOf("") }

    Column(
        Modifier
            .background(Color.Unspecified)
            .fillMaxSize()
            .background(Color.LightGray)
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(30.dp),
            Arrangement.Center
        ) {
            Text("Cadastro Masculo!!!", fontFamily = FontFamily.Cursive, fontSize = 25.sp)
        }

        Row(
            Modifier
                .fillMaxWidth()
                .padding(15.dp),
            Arrangement.Center
        ) {
            TextField(
                value = nome,
                onValueChange = {nome = it},
                label = {Text("Nome")}
            )
        }

        Row(
            Modifier
                .fillMaxWidth()
                .padding(15.dp),
            Arrangement.Center
        ) {
            TextField(
                value = sobre,
                onValueChange = {sobre = it},
                label = {Text("Sobrenome")}
            )
        }

        Row(
            Modifier
                .fillMaxWidth()
                .padding(15.dp),
            Arrangement.Center
        ) {
            TextField(
                value = tel,
                onValueChange = {tel = it},
                label = {Text("Telefone")}
            )
        }

        Row(
            Modifier
                .fillMaxWidth()
                .padding(15.dp),
            Arrangement.Center
        ) {
            TextField(
                value = idade,
                onValueChange = {idade = it},
                label = {Text("Idade")}
            )
        }

        Row(
            Modifier
                .fillMaxWidth()
                .padding(15.dp),
            Arrangement.Center
        ) {
            Button(
                onClick = {
                    val db = Firebase.firestore

                    val Usuario = hashMapOf(
                        "nome" to nome,
                        "sobre" to sobre,
                        "tel" to tel,
                        "idade" to idade
                    )
                    db.collection("Usuario")
                        .add(Usuario)
                        .addOnSuccessListener { documentReference ->
                            Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")

                            nome = ""
                            sobre = ""
                            tel = ""
                            idade = ""
                        }
                        .addOnFailureListener { e ->
                            Log.w(TAG, "Error adding document", e)
                        }
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Black)

            ) {
                Text("Cadastrar" +
                        "", fontSize = 25.sp)
            }
            Button(
                onClick = {
                    val db = Firebase.firestore

                    db.collection("Usuario")
                        .get()
                        .addOnSuccessListener { result ->
                            for (document in result) {
                                Log.d(TAG, "${document.id} => ${document.data}")
                                dados = result.joinToString("\n") { "${it.id} => ${it.data}" }
                            }
                        }
                        .addOnFailureListener { exception ->
                            Log.w(TAG, "Error getting documents.", exception)
                        }
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray)
            ) {
                Text("Consulta", fontSize = 25.sp)
            }
            Text(dados)

        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FogoBaseTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            fogoBase()
        }
    }
}
