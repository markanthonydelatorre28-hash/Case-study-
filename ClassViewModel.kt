package com.example.attendanceapp.viewmodel

import androidx.lifecycle.*
import com.example.attendanceapp.data.entities.ClassEntity
import com.example.attendanceapp.data.repository.AttendanceRepository
import kotlinx.coroutines.launch

class ClassViewModel(private val repo: AttendanceRepository) : ViewModel() {
    val allClasses = repo.getAllClasses()

    fun addClass(name: String, subject: String) = viewModelScope.launch {
        repo.addClass(ClassEntity(className = name, subjectName = subject))
    }

    fun deleteClass(cls: ClassEntity) = viewModelScope.launch {
        repo.deleteClass(cls)
    }
}
