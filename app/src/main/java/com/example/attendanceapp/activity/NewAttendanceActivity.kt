package com.example.attendanceapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.attendanceapp.R
import com.example.attendanceapp.activity.MainActivity.Companion.viewModelInstance
import com.example.attendanceapp.adapters.NewAttendanceAdapter
import com.example.attendanceapp.adapters.NewAttendanceAdapter.Companion.attendance
import com.example.attendanceapp.data.Class
import com.example.attendanceapp.viewmodel.ClassViewModel
import kotlinx.android.synthetic.main.activity_new_attendance.*

class NewAttendanceActivity : AppCompatActivity() {
    private lateinit var viewModel: ClassViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_attendance)
        viewModel = viewModelInstance!!
        val data = intent.getSerializableExtra("data") as Class
        val adapter = NewAttendanceAdapter(this, data.strength)
        Log.e("MyTag", (data.attendance).toString())
        recyclerViewNewAttendance.adapter = adapter
        recyclerViewNewAttendance.layoutManager = LinearLayoutManager(this)
        save_attendance.setOnClickListener {
            viewModel.deleteClass(data)
            for(i in 0 until data.strength){
                data.attendance[i] += attendance[i]
            }
            attendance.clear()
            viewModel.insert(data)
            finish()
        }
    }
}