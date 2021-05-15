package com.example.zeplinnewproject.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.zeplinnewproject.R

class AdapterNewsTop : RecyclerView.Adapter<AdapterNewsTop.NewsTopViewHolder>() {
    private var listData: Array<String> = arrayOf()
    class NewsTopViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.tv_news_top)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): NewsTopViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_list_news_top, viewGroup, false)
        return NewsTopViewHolder(view)
    }

    override fun getItemCount() = listData.size

    override fun onBindViewHolder(viewHolder: NewsTopViewHolder, position: Int) {
        viewHolder.textView.text = listData[position]
    }

    fun setData(listData: Array<String>) {
        this.listData = listData
        notifyDataSetChanged()
    }
}