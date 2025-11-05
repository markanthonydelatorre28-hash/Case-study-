package com.example.attendanceapp.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.attendanceapp.data.entities.*

@Dao
interface AppDao {

    // Classes
    @Insert suspend fun insertClass(cls: ClassEntity)
    @Update suspend fun updateClass(cls: ClassEntity)
    @Delete suspend fun deleteClass(cls: ClassEntity)
    @Query("SELECT * FROM classes ORDER BY className ASC")
    fun getAllClasses(): LiveData<List<ClassEntity>>

    // Students
    @Insert suspend fun insertStudent(student: StudentEntity)
    @Delete suspend fun deleteStudent(student: StudentEntity)
    @Query("SELECT * FROM students WHERE classId = :classId ORDER BY studentName ASC")
    fun getStudentsByClass(classId: Int): LiveData<List<StudentEntity>>

    // Attendance
    @Insert suspend fun insertAttendance(att: AttendanceEntity)
    @Query("SELECT * FROM attendance WHERE date = :date")
    fun getAttendanceByDate(date: String): LiveData<List<AttendanceEntity>>

    @Query("SELECT * FROM attendance WHERE studentId = :studentId")
    fun getAttendanceByStudent(studentId: Int): LiveData<List<AttendanceEntity>>
}
