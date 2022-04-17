package com.example.snoh.recycleveiwadapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.snoh.R
import com.example.snoh.database.TheProject
import kotlinx.coroutines.processNextEventInCurrentThread

class adapter : RecyclerView.Adapter<adapter.MyViewHolder>() {

    private var datalist = emptyList<TheProject>()

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var id : TextView = itemView.findViewById(R.id.id_no)
        var name : TextView = itemView.findViewById(R.id.name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.recyle_item,parent,false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentitem = datalist[position]
        holder.id.text = currentitem.id.toString()
        holder.name.text = currentitem.logic.toString()
    }

    override fun getItemCount(): Int {
        return datalist.size
    }

    fun setdata(datalist : List<TheProject>)
    {
        this.datalist = datalist
        notifyDataSetChanged()
    }
}