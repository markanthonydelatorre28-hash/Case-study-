package com.example.attendanceapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.attendanceapp.ui.screens.*

@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "main") {
        composable("main") { MainMenuScreen(navController) }
        composable("classes") { ClassListScreen(navController) }
        composable("students") { StudentListScreen(navController) }
        composable("attendance") { AttendanceScreen(navController) }
        composable("summary") { SummaryScreen(navController) }
    }
}
