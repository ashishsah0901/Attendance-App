package com.example.attendanceapp.repository

import androidx.room.TypeConverter

class Converters {
    @TypeConverter
    fun fromArrayList(arr: ArrayList<Int>): String{
        var ans = ""
        for(i in arr){
            ans+=i
        }
        return ans
    }
    @TypeConverter
    fun toArrayList(s: String): ArrayList<Int>{
        val ans = ArrayList<Int>()
        for(i in s){
            ans.add(i-'0')
        }
        return ans
    }
}