package com.example.attendanceapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.attendanceapp.R
import com.example.attendanceapp.data.Class
import kotlinx.android.synthetic.main.item_class.view.*

class ClassesAdapter(private val context: Context, private val listener: ClassesAdapterListener): RecyclerView.Adapter<ClassesAdapter.ClassesViewHolder>() {
    private val allClasses = ArrayList<Class>()
    inner class ClassesViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClassesViewHolder {
        val viewHolder = ClassesViewHolder(LayoutInflater.from(context).inflate(R.layout.item_class,parent,false))
        viewHolder.itemView.setOnClickListener {
            listener.onItemClicked(allClasses[viewHolder.adapterPosition])
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: ClassesViewHolder, position: Int) {
        val currentClass = allClasses[position]
        holder.itemView.className.text = currentClass.name
        holder.itemView.numberOfStudents.text = currentClass.strength.toString()
    }

    override fun getItemCount(): Int {
        return allClasses.size
    }
    fun updateClasses(newData: List<Class>){
        allClasses.clear()
        allClasses.addAll(newData)
        notifyDataSetChanged()
    }
}
interface ClassesAdapterListener{
    fun onItemClicked(data: Class)
}