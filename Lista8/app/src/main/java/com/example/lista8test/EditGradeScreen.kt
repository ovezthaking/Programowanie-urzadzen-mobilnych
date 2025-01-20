package com.example.lista8test

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun EditGradeScreen(grade: Grade, onSave: (Grade) -> Unit, onDelete: () -> Unit) {
    var subject by remember { mutableStateOf(grade.subject) }
    var score by remember { mutableStateOf(grade.score) }

    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        TextField(value = subject, onValueChange = { subject = it }, label = { Text("Przedmiot") })
        TextField(value = score.toString(), onValueChange = { score = it.toFloatOrNull() ?: 0f }, label = { Text("Ocena") })

        Button(onClick = { onSave(grade.copy(subject = subject, score = score)) }) {
            Text("Zapisz")
        }
        Button(onClick = onDelete) {
            Text("Usuń")
        }
    }
}