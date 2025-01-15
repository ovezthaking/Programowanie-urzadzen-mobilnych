package com.example.lista7

sealed class Screens(val route: String) {
    data object ListScreen : Screens("list_screen")
    data object DetalScreen : Screens("detal_screen")
}