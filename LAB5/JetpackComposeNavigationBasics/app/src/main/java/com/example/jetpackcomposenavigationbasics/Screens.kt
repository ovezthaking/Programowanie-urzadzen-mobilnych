package com.example.jetpackcomposenavigationbasics

sealed class Screens(val route: String) {
    data object MainScreen : Screens("main_screen")
    data object SecondScreen : Screens("second_screen")
}