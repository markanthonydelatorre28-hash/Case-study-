package com.example.attendanceapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.navigation.NavController
import com.example.attendanceapp.data.entities.ClassEntity

@Composable
fun ClassListScreen(navController: NavController) {
    var classes by remember { mutableStateOf(listOf<ClassEntity>()) }
    var newClass by remember { mutableStateOf("") }
    var newSubject by remember { mutableStateOf("") }

    Scaffold(
        topBar = { TopAppBar(title = { Text("Classes") }) }
    ) { padding ->
        Column(modifier = Modifier.padding(padding).padding(16.dp)) {
            OutlinedTextField(value = newClass, onValueChange = { newClass = it }, label = { Text("Class Name") })
            OutlinedTextField(value = newSubject, onValueChange = { newSubject = it }, label = { Text("Subject Name") })
            Button(onClick = {
                if (newClass.isNotBlank() && newSubject.isNotBlank()) {
                    classes = classes + ClassEntity(className = newClass, subjectName = newSubject)
                    newClass = ""; newSubject = ""
                }
            }) {
                Text("Add Class")
            }
            LazyColumn {
                items(classes.size) { i ->
                    Text("${classes[i].className} - ${classes[i].subjectName}")
                }
            }
        }
    }
}
