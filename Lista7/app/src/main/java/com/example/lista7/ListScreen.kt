package com.example.lista7

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ListScreen(onDetalScreen: (String) -> Unit, viewModel: StudentListViewModel) {
    val students by viewModel.students.collectAsState()





    Column(
        Modifier
            .fillMaxSize()
            .background(color = Color.Black),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        LazyColumn(
            Modifier
                .fillMaxSize()
                .padding(50.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            items(students) { student ->
                Column(
                    Modifier
                        .padding(top = 10.dp)
                        .fillMaxSize()
                        .clickable {
                            student.indexNumber?.let {
                                Log.d("ListScreen", "Navigating with indexNumber: $it")
                                onDetalScreen(it)
                            }
                        }
                        .defaultMinSize(minHeight = 35.dp)
                        .background(
                            color = Color.Gray.copy(alpha = 0.5f),
                            shape = androidx.compose.foundation.shape.RoundedCornerShape(10.dp)
                        ),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = " ${student.name} ${student.lastName}\n\n  ${student.indexNumber}",
                        Modifier
                            .fillMaxSize(),
                        color = Color.LightGray
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun ListScreenPreview() {
    ListScreen(onDetalScreen = {}, viewModel = StudentListViewModel())
}