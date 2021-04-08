package com.example.attendanceapp.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.attendanceapp.R
import com.example.attendanceapp.adapters.ClassesAdapter
import com.example.attendanceapp.adapters.ClassesAdapterListener
import com.example.attendanceapp.data.Class
import com.example.attendanceapp.viewmodel.ClassViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ClassesAdapterListener{
    companion object{
        var viewModelInstance: ClassViewModel?=null
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val adapter = ClassesAdapter(this,this)
        main_recycler_view.adapter = adapter
        main_recycler_view.layoutManager = LinearLayoutManager(this)
        viewModelInstance = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(ClassViewModel::class.java)
        viewModelInstance!!.allClasses.observe(this, {
            it?.let {
                adapter.updateClasses(it)
            }
        })
        new_class_button.setOnClickListener {
            startActivity(Intent(this, NewClassActivity::class.java))
        }
    }
    override fun onItemClicked(data: Class){
        val intent = Intent(this, ClassActivity::class.java)
        intent.putExtra("class",data)
        Log.e("MyTag", (data.attendance).toString())
        startActivity(intent)
    }
}