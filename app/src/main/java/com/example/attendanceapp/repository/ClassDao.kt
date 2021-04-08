package com.example.attendanceapp.repository

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.attendanceapp.data.Class

@Dao
interface ClassDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(data: Class)

    @Delete
    suspend fun delete(data: Class)

    @Query("SELECT * FROM class_data order by strength ASC")
    fun getAllClasses(): LiveData<List<Class>>
}