package com.example.attendanceapp.viewmodel

import androidx.lifecycle.*
import com.example.attendanceapp.data.entities.StudentEntity
import com.example.attendanceapp.data.repository.AttendanceRepository
import kotlinx.coroutines.launch

class StudentViewModel(private val repo: AttendanceRepository) : ViewModel() {

    fun getStudentsByClass(classId: Int) = repo.getStudentsByClass(classId)

    fun addStudent(name: String, idNumber: String, classId: Int) = viewModelScope.launch {
        repo.addStudent(StudentEntity(studentName = name, studentIdNumber = idNumber, classId = classId))
    }

    fun deleteStudent(student: StudentEntity) = viewModelScope.launch {
        repo.deleteStudent(student)
    }
}
