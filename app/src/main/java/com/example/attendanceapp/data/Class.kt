package com.example.attendanceapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "class_data")
class Class(@ColumnInfo(name = "class") val name: String, val strength: Int, val attendance: ArrayList<Int>): Serializable{
    @PrimaryKey(autoGenerate = true)var id:Int = 0
}