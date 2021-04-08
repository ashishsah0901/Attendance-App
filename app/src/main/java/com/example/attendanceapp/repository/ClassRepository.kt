package com.example.attendanceapp.repository

import androidx.lifecycle.LiveData
import com.example.attendanceapp.data.Class

class ClassRepository(private val classDao: ClassDao) {
    val allClasses: LiveData<List<Class>> = classDao.getAllClasses()
    suspend fun insert(data: Class){
        classDao.insert(data)
    }
    suspend fun delete(data: Class){
        classDao.delete(data)
    }
}