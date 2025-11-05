package com.example.attendanceapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.navigation.NavController
import com.example.attendanceapp.data.entities.StudentEntity

@Composable
fun StudentListScreen(navController: NavController) {
    var students by remember { mutableStateOf(listOf<StudentEntity>()) }
    var name by remember { mutableStateOf("") }
    var idNum by remember { mutableStateOf("") }

    Scaffold(topBar = { TopAppBar(title = { Text("Students") }) }) { padding ->
        Column(modifier = Modifier.padding(padding).padding(16.dp)) {
            OutlinedTextField(value = name, onValueChange = { name = it }, label = { Text("Student Name") })
            OutlinedTextField(value = idNum, onValueChange = { idNum = it }, label = { Text("Student ID") })
            Button(onClick = {
                if (name.isNotBlank() && idNum.isNotBlank()) {
                    students = students + StudentEntity(studentName = name, studentIdNumber = idNum, classId = 1)
                    name = ""; idNum = ""
                }
            }) { Text("Add Student") }

            LazyColumn {
                items(students.size) { i ->
                    Text("${students[i].studentName} (${students[i].studentIdNumber})")
                }
            }
        }
    }
}
