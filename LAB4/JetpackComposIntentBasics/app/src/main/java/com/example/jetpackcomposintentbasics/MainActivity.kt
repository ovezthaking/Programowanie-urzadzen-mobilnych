package com.example.jetpackcomposintentbasics

import android.content.Context
import android.content.Intent
import android.content.Intent.CATEGORY_BROWSABLE
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpackcomposintentbasics.ui.theme.JetpackComposIntentBasicsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackComposIntentBasicsTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ImplicitIntentButton()
                }
            }
        }
    }
}

@Composable
fun ImplicitIntentButton() {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Button(
            onClick = { openHomepage(context) },
            shape = RectangleShape,
            modifier = Modifier.fillMaxWidth(0.6f),
        ) {
            Text(text = "OPEN HOMEPAGE")
        }
    }
}

fun openHomepage(context: Context) {
    val url = "https://netcat.uwr.edu.pl/"
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url)).apply{
        addCategory(CATEGORY_BROWSABLE)
    }

    context.startActivity(intent)
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    JetpackComposIntentBasicsTheme {
        ImplicitIntentButton()
    }
}