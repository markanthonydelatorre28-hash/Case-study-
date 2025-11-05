package com.example.attendanceapp.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "attendance")
data class AttendanceEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val date: String,
    val studentId: Int,
    val status: String // Present, Absent, Late
)
