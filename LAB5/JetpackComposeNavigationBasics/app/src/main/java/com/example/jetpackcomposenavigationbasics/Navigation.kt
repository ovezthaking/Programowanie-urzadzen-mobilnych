package com.example.jetpackcomposenavigationbasics

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screens.MainScreen.route) {
        composable(route = Screens.MainScreen.route){
            val arg = 5
            MainScreen{navController.navigate(Screens.SecondScreen.route + "/$arg")}
        }

        composable(route = Screens.SecondScreen.route + "/{arg}"){
            val arg = it.arguments?.getString("arg")
            SecondScreen(arg) {navController.popBackStack()}
        }
    }
}