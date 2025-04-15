package com.example.examen.ui.navigation

sealed class Routes(val route: String) {
    object Search : Routes("search")
    object Saved : Routes("saved")
}