package com.example.livedatabasicscompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.livedatabasicscompose.ui.theme.LiveDataBasicsComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LiveDataBasicsComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                )  {
                    CounterScreen()
                }
            }
        }
    }
}


@Composable
fun CounterScreen() {

    val viewModel: CounterViewModel = viewModel() // zapewnia dostęp do metod dostępowych i danych (tylko do odczytu)
    val counterState = viewModel.counter.observeAsState() // przy każdej zmianie wartości counter,
    // counterState otrzymuje aktualną wartość

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Spacer(modifier = Modifier.weight(0.3f))
        Text(
            text = counterState.value.toString(),
            fontSize = 250.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.weight(1f),
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(
                modifier = Modifier
                    .weight(.5f)
                    .padding(4.dp),
                shape = RoundedCornerShape(4.dp),
                onClick = {viewModel.increase()} // przycisk zwiększający stan licznika o 1
            ) {
                Text(text = "Increase")
            }
            Button(
                modifier = Modifier
                    .weight(.5f)
                    .padding(4.dp),
                shape = RoundedCornerShape(4.dp),
                onClick = {viewModel.decrease()} // przycisk zmniejszający stan licznika o 1
            ) {
                Text(text = "Decrease")
            }
        }

        Button(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth(),
            shape = RectangleShape,
            onClick = {viewModel.clear()} // przycisk ustawiający stan licznika na 0
        ) {
            Text(text = "Reset")
        }
    }
}





@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LiveDataBasicsComposeTheme {
        Greeting("Android")
    }
}