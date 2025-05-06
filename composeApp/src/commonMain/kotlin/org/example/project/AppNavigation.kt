package org.example.project

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import org.example.project.screens.HomeScreen
import org.example.project.screens.ScheduleScreen

@Composable
fun AppNavigation(navController: NavHostController, viewModel: SharedViewModel) {

    NavHost(navController, "home") {
        composable("home") { HomeScreen(navController, viewModel) }
        composable("schedule") { ScheduleScreen(navController, viewModel) }
    }
}