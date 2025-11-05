package com.example.attendanceapp.data.repository

import androidx.lifecycle.LiveData
import com.example.attendanceapp.data.dao.AppDao
import com.example.attendanceapp.data.entities.*

class AttendanceRepository(private val dao: AppDao) {

    // Classes
    fun getAllClasses(): LiveData<List<ClassEntity>> = dao.getAllClasses()
    suspend fun addClass(classEntity: ClassEntity) = dao.insertClass(classEntity)
    suspend fun updateClass(classEntity: ClassEntity) = dao.updateClass(classEntity)
    suspend fun deleteClass(classEntity: ClassEntity) = dao.deleteClass(classEntity)

    // Students
    fun getStudentsByClass(classId: Int): LiveData<List<StudentEntity>> = dao.getStudentsByClass(classId)
    suspend fun addStudent(student: StudentEntity) = dao.insertStudent(student)
    suspend fun deleteStudent(student: StudentEntity) = dao.deleteStudent(student)

    // Attendance
    fun getAttendanceByDate(date: String): LiveData<List<AttendanceEntity>> = dao.getAttendanceByDate(date)
    fun getAttendanceByStudent(studentId: Int): LiveData<List<AttendanceEntity>> = dao.getAttendanceByStudent(studentId)
    suspend fun addAttendance(attendance: AttendanceEntity) = dao.insertAttendance(attendance)
}
