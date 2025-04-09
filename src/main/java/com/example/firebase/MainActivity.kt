package com.example.firebase

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.firebase.ui.theme.FireBaseTheme
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FireBaseTheme {
                    App()
            }
        }
    }
}


@Composable
fun App() {

    val textNome = remember { mutableStateOf("") }
    val textSobre = remember { mutableStateOf("")}
    val textTel = remember { mutableStateOf("") }
    val textIdade = remember { mutableStateOf("") }

    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
        ) {
            Text(
                text = buildAnnotatedString {
                    // Parte do texto que será preta
                    append("Pra testar o ")

                    // Parte do texto que será vermelha (FireBase)
                    withStyle(style = SpanStyle(color = Color(0xFFF44336))) {
                        append("FogoBase")
                    }

                    // Parte do texto que será preta novamente
                    append("!")
                },
                style = MaterialTheme.typography.headlineMedium.copy(
                    color = Color(0xFF87769D),
                    fontSize = 24.sp, // Tamanho da fonte
                    fontWeight = FontWeight.Bold, // Peso da fonte (negrito)
                    letterSpacing = 1.5.sp, // Espaçamento entre as letras
                    lineHeight = 32.sp, // Altura da linha
                    textAlign = TextAlign.Center // Alinhamento do texto
                ),
                modifier = Modifier.padding(bottom = 16.dp) // Padding opcional
            )


            TextField(
                value = textNome.value, // O valor do TextField
                onValueChange = { textNome.value = it }, // Atualiza o valor quando o usuário digita

                label = { Text("Digite seu Nome: ") }, // Texto do label (opcional)
                singleLine = true, // Faz o campo de texto ser uma linha única
                modifier = Modifier
                    .fillMaxWidth(0.75f) // Largura de 100%
                    .padding(top = 30.dp, bottom = 30.dp)
            )

            TextField(
                value = textSobre.value, // O valor do TextField
                onValueChange = { textSobre.value = it }, // Atualiza o valor quando o usuário digita
                label = { Text("Digite o Sobrenome: ") }, // Texto do label (opcional)
                singleLine = true, // Faz o campo de texto ser uma linha única
                modifier = Modifier
                    .fillMaxWidth(0.75f) // Largura de 100%
                    .padding(bottom = 30.dp)
            )

            TextField(
                value = textTel.value, // O valor do TextField
                onValueChange = { textTel.value = it }, // Atualiza o valor quando o usuário digita
                label = { Text("Digite seu Número: ") }, // Texto do label (opcional)
                singleLine = true, // Faz o campo de texto ser uma linha única
                modifier = Modifier
                    .fillMaxWidth(0.75f) // Largura de 100%
                    .padding(bottom = 30.dp)
            )

            TextField(
                value = textIdade.value, // O valor do TextField
                onValueChange = { textIdade.value = it }, // Atualiza o valor quando o usuário digita
                label = { Text("Digite a sua idade: ") }, // Texto do label (opcional)
                singleLine = true, // Faz o campo de texto ser uma linha única
                modifier = Modifier
                    .fillMaxWidth(0.75f) // Largura de 100%
                    .padding(bottom = 30.dp)
            )

            Button(
                onClick = { val db = Firebase.firestore
                    // Create a new user with a first and last name
                    val user = hashMapOf(
                        "" to "Ada",
                        "last" to "Lovelace",
                        "born" to 1815
                    )

// Add a new document with a generated ID
                    db.collection("users")
                        .add(user)
                        .addOnSuccessListener { documentReference ->
                            Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
                        }
                        .addOnFailureListener { e ->
                            Log.w(TAG, "Error adding document", e)
                        }

                          },
                modifier = Modifier.padding(16.dp),
                shape = RoundedCornerShape(12.dp), // Borda arredondada
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF87769D), // Cor de fundo do botão
                    contentColor = Color.White // Cor do texto
                )
            ) {
                Text(text = "Clique aqui") // Texto do botão
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppPreview() {
    FireBaseTheme {
        App()
    }
}