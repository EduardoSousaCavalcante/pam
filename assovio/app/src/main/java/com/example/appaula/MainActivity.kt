package com.example.appaula

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.composable
import com.example.appaula.navigation.AppNavigation
import com.example.appaula.navigation.AppRoot
import com.example.appaula.ui.screen.HomeScreen
import com.example.appaula.ui.screen.InsertScreen
import com.example.appaula.ui.theme.AppAulaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // enableEdgeToEdge()
        setContent {
            AppAulaTheme {
                AppRoot()
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun AppPreview() {
    AppAulaTheme {
        AppRoot()
    }
}
