package com.example.viewmodelbasicscompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import com.example.viewmodelbasicscompose.ui.theme.ViewModelBasicsComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ViewModelBasicsComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ListScreen()
                }
            }
        }
    }
}


object DataProvider {
    val words: List<String> = listOf(
        "dom",
        "ojciec",
        "matka",
        "piękno",
        "ból",
        "szkoła",
        "miłość",
        "praca",
        "twarz",
        "noc",
        "dzień",
        "stół",
        "kawa",
        "pies",
        "kot",
        "dziecko",
        "prawo",
        "cisza",
        "piosenka",
        "szczęście",
        "słońce",
        "długo",
        "krótka",
        "drzewo",
        "kwiat",
        "woda",
        "noga",
        "ręka",
        "mężczyzna",
        "kobieta",
        "czas",
        "malarz",
        "muzyka",
        "kolor",
        "głowa",
        "brzuch",
        "długie",
        "krótki",
        "serce",
        "oko",
        "miska",
        "lustro",
        "słowo",
        "most",
        "szybko",
        "sklep",
        "kino",
        "dziadek",
        "babcia",
        "lampa"
    )
}

class WordViewModel : ViewModel() {
    private var _wordsList = mutableStateListOf<String>()
    val wordList: List<String>
        get() = _wordsList

    init {
        reinitialize()
    }

    fun addWord(word: String){
        _wordsList.add(word)
        _wordsList.sort()
    }

    fun reinitialize(){
        _wordsList.clear()
        _wordsList.addAll(DataProvider.words)
        _wordsList.sort()
    }

    fun clear(){
        _wordsList.clear()
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
    ViewModelBasicsComposeTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            ListScreen()
        }
    }
}