package com.example.jetpackcomposestatebasics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposestatebasics.ui.theme.JetpackComposeStateBasicsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeStateBasicsTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CounterExample()
                }
            }
        }
    }
}

@Composable
fun CounterExample() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {

        /*
        val count: MutableState<Int> = rememberSaveable{
            mutableIntStateOf(0)
        }*/

        var count by rememberSaveable{
            mutableIntStateOf(0)
        }

        Spacer(modifier = Modifier.weight(0.3f))

        Text(
            text = "${count}",
            fontSize = 250.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.weight(1f),
        )

        Button(
            onClick = { count++ }, // onclick
            modifier = Modifier.fillMaxWidth(),
            shape = RectangleShape
        ) {
            Text(text = "COUNT UP")
        }
    }
}


    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        JetpackComposeStateBasicsTheme {
            CounterExample()
        }
    }
