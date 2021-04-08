package com.example.attendanceapp.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.attendanceapp.R
import com.example.attendanceapp.activity.MainActivity.Companion.viewModelInstance
import com.example.attendanceapp.adapters.StudentsAttendanceAdapter
import com.example.attendanceapp.data.Class
import com.example.attendanceapp.viewmodel.ClassViewModel
import kotlinx.android.synthetic.main.activity_class.*

class ClassActivity : AppCompatActivity() {
    private lateinit var viewModel: ClassViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_class)
        val data = intent.getSerializableExtra("class") as Class
        val adapter = StudentsAttendanceAdapter(this, data.attendance)
        recycler_view_class.adapter = adapter
        recycler_view_class.layoutManager = LinearLayoutManager(this)
        viewModel = viewModelInstance!!
        delete_class.setOnClickListener {
            viewModel.deleteClass(data)
            finish()
        }
        reset_data.setOnClickListener {
            viewModel.deleteClass(data)
            val attendance = ArrayList<Int>()
            for(i in 0..data.strength){
                attendance.add(0)
            }
            viewModel.insert(Class(data.name,data.strength, attendance))
            finish()
        }
        new_class_button.setOnClickListener {
            val intent = Intent(this, NewAttendanceActivity::class.java)
            intent.putExtra("data",data)
            startActivity(intent)
            finish()
        }
    }
}