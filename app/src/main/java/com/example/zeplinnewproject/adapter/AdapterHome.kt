package com.example.zeplinnewproject.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.zeplinnewproject.R
import com.example.zeplinnewproject.model.HomeObject

class AdapterHome : RecyclerView.Adapter<AdapterHome.HomeViewHolder>() {
    private var listData: MutableList<HomeObject> = mutableListOf()

    fun setData(listData: MutableList<HomeObject>) {
        this.listData = listData
        notifyDataSetChanged()
    }

    class HomeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var textView1: TextView = view.findViewById(R.id.tv_name)
        var textView2: TextView = view.findViewById(R.id.tv_index)
        var textView3: TextView = view.findViewById(R.id.tv_time)
        var textView4: TextView = view.findViewById(R.id.tv_value)
        var textView5: TextView = view.findViewById(R.id.tv_value_bonus)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): HomeViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_list_home, viewGroup, false)
        return HomeViewHolder(view)
    }

    override fun getItemCount() = listData.size

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(viewHolder: HomeViewHolder, position: Int) {
        viewHolder.textView1.text = listData[position].name + " $position"
        viewHolder.textView2.text = listData[position].index
        viewHolder.textView3.text = listData[position].time
        viewHolder.textView4.text = listData[position].value
        viewHolder.textView5.text = listData[position].valueBonus
    }
}