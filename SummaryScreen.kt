package com.example.attendanceapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.navigation.NavController

@Composable
fun SummaryScreen(navController: NavController) {
    Scaffold(topBar = { TopAppBar(title = { Text("Attendance Summary") }) }) { padding ->
        Column(modifier = Modifier.padding(padding).padding(16.dp)) {
            Text("Attendance summary and stats will appear here.")
        }
    }
}
