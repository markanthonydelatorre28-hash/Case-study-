package com.example.attendanceapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.navigation.NavController
import com.example.attendanceapp.data.entities.StudentEntity

@Composable
fun AttendanceScreen(navController: NavController) {
    var students by remember {
        mutableStateOf(
            listOf(
                StudentEntity(studentName = "Juan Dela Cruz", studentIdNumber = "2025-001", classId = 1),
                StudentEntity(studentName = "Maria Santos", studentIdNumber = "2025-002", classId = 1)
            )
        )
    }

    val statuses = listOf("Present", "Absent", "Late")
    val marked = remember { mutableStateMapOf<Int, String>() }

    Scaffold(topBar = { TopAppBar(title = { Text("Mark Attendance") }) }) { padding ->
        Column(modifier = Modifier.padding(padding).padding(16.dp)) {
            LazyColumn {
                items(students.size) { i ->
                    val s = students[i]
                    Text(s.studentName)
                    Row {
                        statuses.forEach { status ->
                            val selected = marked[s.id] == status
                            FilterChip(
                                selected = selected,
                                onClick = { marked[s.id] = status },
                                label = { Text(status) }
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                        }
                    }
                    Divider()
                }
            }
        }
    }
}
