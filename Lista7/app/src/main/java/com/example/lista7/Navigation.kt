package com.example.lista7

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument


@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screens.ListScreen.route) {
        composable(route = Screens.ListScreen.route){
            val viewModel = viewModel<StudentListViewModel>()
            ListScreen(onDetalScreen = { indexNumber ->
                Log.d("Navigation", "Navigating with indexNumber: $indexNumber")
                navController.navigate(Screens.DetalScreen.route + "?indexNumber=$indexNumber")
            }, viewModel = viewModel)
        }

        composable(
            route = Screens.DetalScreen.route + "?indexNumber={indexNumber}",
            arguments = listOf(navArgument("indexNumber") { type = NavType.StringType })
        ){ backStackEntry ->
            val indexNumber = backStackEntry.arguments?.getString("indexNumber")
            Log.d("Navigation", "Received indexNumber: $indexNumber")
            val viewModel = viewModel<StudentListViewModel>()
            DetalScreen(indexNumber = indexNumber, onHome = {navController.popBackStack()}, viewModel = viewModel)
        }
    }
}