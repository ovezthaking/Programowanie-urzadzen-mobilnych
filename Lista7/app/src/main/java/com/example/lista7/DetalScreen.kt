package com.example.lista7

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lista7.DataProvider.students

@Composable
fun DetalScreen(indexNumber: String?, onHome: () -> Unit, viewModel: StudentListViewModel) {
    val students by viewModel.students.collectAsState()
    Log.d("DetalScreen", "indexNumber: $indexNumber")
    Log.d("DetalScreen", "students: $students")
    val student = students.find {
        Log.d("DetalScreen", "Comparing ${it.indexNumber} with $indexNumber")
        it.indexNumber.equals(indexNumber)
    }
    Log.d("DetalScreen", "student: $student")

    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        student?.let {
            Text(
                "Imię i nazwisko: ${it.name} ${it.lastName} \n" +
                        "Numer indeksu: ${it.indexNumber}\n" +
                        "Rok: ${it.academicYear} \n" +
                        "Średnia ocen: ${it.gradesMean}"
            )
            Spacer(modifier = Modifier.height(8.dp))
        } ?: Text("Student not found")
    }
}

@Preview(showBackground = true)
@Composable
fun DetalScreenPreview() {
    DetalScreen(indexNumber = "31234", onHome = {}, viewModel = StudentListViewModel())
}