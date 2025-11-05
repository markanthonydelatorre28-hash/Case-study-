package com.example.attendanceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.attendanceapp.ui.navigation.AppNavHost
import com.example.attendanceapp.ui.theme.AttendanceAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AttendanceAppTheme {
                val navController = rememberNavController()
                AppNavHost(navController)
            }
        }
    }
}
