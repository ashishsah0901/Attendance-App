package com.example.attendanceapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.attendanceapp.R
import com.example.attendanceapp.data.Class
import kotlinx.android.synthetic.main.item_new_attendance.view.*

class NewAttendanceAdapter(private val context: Context, private val strength: Int): RecyclerView.Adapter<NewAttendanceAdapter.NewAttendanceViewHolder>() {
    companion object{
        val attendance = ArrayList<Int>()
    }
    inner class NewAttendanceViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewAttendanceViewHolder {
        for(i in 0..strength){
            if(i<=attendance.size){
                attendance.add(0)
            }
        }
        return NewAttendanceViewHolder(LayoutInflater.from(context).inflate(R.layout.item_new_attendance,parent,false))
    }

    override fun onBindViewHolder(holder: NewAttendanceViewHolder, position: Int) {
        holder.itemView.roll_call_number.text ="Roll no. ${position+1}"
        holder.itemView.radio_bt_absent.isChecked = true
        holder.itemView.radio_bt_present.setOnClickListener {
            attendance[position] = 1
            holder.itemView.radio_bt_present.isChecked = true
        }
        holder.itemView.radio_bt_absent.setOnClickListener {
            attendance[position] = 0
            holder.itemView.radio_bt_absent.isChecked = true
        }
    }

    override fun getItemCount(): Int {
        return strength
    }
}