package com.thesis.rra.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.thesis.rra.ui.screens.LoginScreenUI
import com.thesis.rra.ui.screens.MainScreenUI
import com.thesis.rra.ui.screens.RegisterScreenUI
import com.thesis.rra.ui.screens.RestaurantTypeUI

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.Main.route) {
        composable(route = Screen.Login.route) {
            LoginScreenUI(navController = navController)
        }

        composable(route = Screen.Register.route) {
            RegisterScreenUI(navController = navController)
        }
        
        composable(route = Screen.Main.route) {
            MainScreenUI(navController = navController)
        }

        composable(route = Screen.RestaurantType.route + "/{type}") { backStackEntry ->
            backStackEntry.arguments?.getString("type")
                ?.let { RestaurantTypeUI(navController = navController, it) }
        }
    }
}