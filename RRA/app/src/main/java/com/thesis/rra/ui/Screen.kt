package com.thesis.rra.ui

sealed class Screen(val route: String) {
    object Main : Screen("main_screen")
    object Login : Screen("login_screen")
    object Register : Screen("register_screen")
}