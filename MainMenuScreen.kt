package com.example.attendanceapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun MainMenuScreen(navController: NavController) {
    Scaffold(
        topBar = { TopAppBar(title = { Text("Student Attendance Tracker") }) }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Button(onClick = { navController.navigate("classes") }, modifier = Modifier.fillMaxWidth()) {
                Text("Manage Classes")
            }
            Button(onClick = { navController.navigate("students") }, modifier = Modifier.fillMaxWidth()) {
                Text("Manage Students")
            }
            Button(onClick = { navController.navigate("attendance") }, modifier = Modifier.fillMaxWidth()) {
                Text("Mark Attendance")
            }
            Button(onClick = { navController.navigate("summary") }, modifier = Modifier.fillMaxWidth()) {
                Text("View Summary")
            }
        }
    }
}
