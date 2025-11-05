package com.example.attendanceapp.viewmodel

import androidx.lifecycle.*
import com.example.attendanceapp.data.entities.AttendanceEntity
import com.example.attendanceapp.data.repository.AttendanceRepository
import kotlinx.coroutines.launch

class AttendanceViewModel(private val repo: AttendanceRepository) : ViewModel() {

    fun getAttendanceByDate(date: String) = repo.getAttendanceByDate(date)

    fun markAttendance(studentId: Int, date: String, status: String) = viewModelScope.launch {
        repo.addAttendance(
            AttendanceEntity(
                studentId = studentId,
                date = date,
                status = status
            )
        )
    }
}
