package com.example.attendanceapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.attendanceapp.data.Class
import com.example.attendanceapp.repository.ClassDatabase
import com.example.attendanceapp.repository.ClassRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ClassViewModel(application: Application): AndroidViewModel(application) {
    val allClasses: LiveData<List<Class>>
    private val repository: ClassRepository
    init {
        val dao = ClassDatabase.getDatabase(application).getClassDao()
        repository = ClassRepository(dao)
        allClasses = repository.allClasses
    }
    fun deleteClass(data: Class) = viewModelScope.launch(Dispatchers.IO) {
        repository.delete(data)
    }
    fun insert(data: Class) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(data)
    }
}