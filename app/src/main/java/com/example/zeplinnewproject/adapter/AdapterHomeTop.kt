package com.example.zeplinnewproject.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.zeplinnewproject.R

class AdapterHomeTop(private val listData: Array<String>) :
    RecyclerView.Adapter<AdapterHomeTop.MenuViewHolder>() {

    class MenuViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.tv_item_menu)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): MenuViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_menu, viewGroup, false)
        return MenuViewHolder(view)
    }

    override fun getItemCount() = listData.size

    override fun onBindViewHolder(viewHolder: MenuViewHolder, position: Int) {
        viewHolder.textView.text = listData[position]
    }
}