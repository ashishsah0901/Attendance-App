package com.example.attendanceapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.attendanceapp.R
import com.example.attendanceapp.data.Class
import kotlinx.android.synthetic.main.item_students.view.*

class StudentsAttendanceAdapter(private val context: Context, private val data: ArrayList<Int>): RecyclerView.Adapter<StudentsAttendanceAdapter.StudentsAttendanceViewHolder>(){
    inner class StudentsAttendanceViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentsAttendanceViewHolder {
        return StudentsAttendanceViewHolder(LayoutInflater.from(context).inflate(R.layout.item_students,parent,false))
    }

    override fun onBindViewHolder(holder: StudentsAttendanceViewHolder, position: Int) {
        holder.itemView.studentName.text = "Roll no. $position"
        holder.itemView.numberOfLectures.text = "${data[position]}"
    }

    override fun getItemCount(): Int {
        return data.size
    }
}