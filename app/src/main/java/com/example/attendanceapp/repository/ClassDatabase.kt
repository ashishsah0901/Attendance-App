package com.example.attendanceapp.repository

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.attendanceapp.data.Class

@TypeConverters(Converters::class)
@Database(entities = [Class::class], version = 1, exportSchema = false)
abstract class ClassDatabase:RoomDatabase() {
    abstract fun getClassDao(): ClassDao
    companion object{
        @Volatile
        private var INSTANCE: ClassDatabase? = null
        fun getDatabase(context: Context): ClassDatabase {
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ClassDatabase::class.java,
                    "class_data"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}