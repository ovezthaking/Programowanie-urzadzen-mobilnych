package com.example.lista8test

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.lista8test.GradeViewModel

@Composable
fun AppNavHost(navController: NavHostController, viewModel: GradeViewModel) {
    NavHost(navController, startDestination = "grade_list") {
        composable("grade_list") {
            GradeListScreen(
                viewModel = viewModel,
                onEdit = { grade ->
                    navController.navigate("edit_grade/${grade.id}")
                },
                onAdd = { navController.navigate("add_grade") }
            )
        }
        composable("edit_grade/{gradeId}") { backStackEntry ->
            val gradeId = backStackEntry.arguments?.getString("gradeId")?.toInt() ?: return@composable

            val grade = remember { mutableStateOf<Grade?>(null) }

            LaunchedEffect(gradeId) {
                grade.value = viewModel.getGradeById(gradeId)
            }

            grade.value?.let { existingGrade ->
                EditGradeScreen(
                    grade = existingGrade,
                    onSave = { updatedGrade ->
                        viewModel.update(updatedGrade)
                        navController.popBackStack()
                    },
                    onDelete = {
                        viewModel.delete(existingGrade)
                        navController.popBackStack()
                    }
                )
            } ?: run {
                // Może wyświetlić jakiś ekran lub komunikat, jeśli ocena jest null
            }
        }

        composable("add_grade") {
            AddGradeScreen(onAdd = { newGrade ->
                viewModel.insert(newGrade)
                navController.popBackStack()
            })
        }
    }
}