package com.example.lista8test

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lista8test.GradeViewModel

@Composable
fun GradeListScreen(viewModel: GradeViewModel, onEdit: (Grade) -> Unit, onAdd: () -> Unit) {
    val grades by viewModel.allGrades.collectAsState(initial = emptyList())

    Column(modifier = Modifier.padding(16.dp).fillMaxSize()) {
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn(modifier = Modifier.padding(top=50.dp).height(300.dp)) {

            items(grades) { grade ->
                Row(modifier = Modifier.padding(10.dp).background(color = Color.LightGray, shape = androidx.compose.foundation.shape.RoundedCornerShape(10.dp)).height(40.dp).fillMaxWidth(), horizontalArrangement = Arrangement.Center){

                    Text(
                        modifier = Modifier.clickable { onEdit(grade) }.padding(10.dp),
                        text = "${grade.subject} - ${grade.score}"
                    )
                }
            }
        }



        Row( modifier = Modifier
            .height(400.dp).fillMaxWidth(),horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.Bottom){
            Text("Średnia ocen: ${grades.map { it.score }.average()}", modifier = Modifier.padding(10.dp).background(color = Color.Gray, shape = androidx.compose.foundation.shape.RoundedCornerShape(10.dp)).width(150.dp).height(50.dp).wrapContentHeight(), textAlign = TextAlign.Center )

        }
        Row(
            modifier = Modifier
                .fillMaxSize()
                .height(50.dp)
                .padding(bottom = 150.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.Bottom
        ) {

            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = onAdd, modifier = Modifier.padding(bottom = 2.dp)) {
                Text("NOWY")
            }
        }

    }
}

@Preview
@Composable
fun GradeListScreenPreview() {
}