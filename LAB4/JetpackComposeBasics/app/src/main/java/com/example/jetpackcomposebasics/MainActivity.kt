package com.example.jetpackcomposebasics

import android.os.Bundle
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
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpackcomposebasics.ui.theme.JetpackComposeBasicsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Cyan),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = "Jeden")
                Text(text = "Dwa")
            }
        }
    }
    }
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {

    /*

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Cyan),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Jeden")
        Text(text = "Dwa")
    }
    *//*
    Column(
    modifier = Modifier.fillMaxSize(),
    verticalArrangement = Arrangement.spacedBy(8.dp)
) {
    Text(
        text = "Element 1",
        modifier = Modifier.size(50.dp)
    )
    Text(
        text = "Element 2",
        modifier = Modifier.size(80.dp)
    )
    Text(
        text = "Element 3",
        modifier = Modifier.size(100.dp)
    )
}
     */
    Row(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Cyan),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "Jeden")
        Text(text = "Dwa")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackComposeBasicsTheme {
        Greeting("Android")
    }
}