package com.example.lista4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.lista4.ui.theme.Lista4Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lista4Theme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    QuizUI()
                }
            }
        }
    }
}

@Composable
fun QuizUI() {
    Text(
        text = "Hello!",
    )
}

@Preview(showBackground = true)
@Composable
fun QuizPreview() {
    Lista4Theme {
        QuizUI()
    }
}