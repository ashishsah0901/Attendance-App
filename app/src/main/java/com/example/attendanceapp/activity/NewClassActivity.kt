package com.example.attendanceapp.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.attendanceapp.R
import com.example.attendanceapp.activity.MainActivity.Companion.viewModelInstance
import com.example.attendanceapp.data.Class
import com.example.attendanceapp.viewmodel.ClassViewModel
import kotlinx.android.synthetic.main.activity_new_class.*
import java.util.*
import kotlin.collections.ArrayList

class NewClassActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_class)
        btNewClass.setOnClickListener {
            val name = etClassName.text.toString()
            val strength = etClassCount.text.toString()
            val attendance = ArrayList<Int>()
            for(i in 0 until strength.toInt()){
                attendance.add(0)
            }
            val data = Class(name, strength.toInt(), attendance)
            val intent = Intent(this,NewAttendanceActivity::class.java)
            intent.putExtra("data",data)
            startActivity(intent)
            finish()
        }
    }
}