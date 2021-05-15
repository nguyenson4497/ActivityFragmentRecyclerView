package com.example.zeplinnewproject.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.zeplinnewproject.R
import com.example.zeplinnewproject.model.NewsObject

class AdapterNews : RecyclerView.Adapter<AdapterNews.NewsViewHolder>() {
    private var listData: MutableList<NewsObject> = mutableListOf()

    fun setData(listData: MutableList<NewsObject>) {
        this.listData = listData
        notifyDataSetChanged()
    }

    inner class NewsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var resource: ImageView = view.findViewById(R.id.iv_news_image_list)
        var name: TextView = view.findViewById(R.id.tv_news_name)
        var discount: TextView = view.findViewById(R.id.tv_news_discount)
        var date: TextView = view.findViewById(R.id.tv_news_date)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_list_news, viewGroup, false)
        return NewsViewHolder(view)
    }

    override fun getItemCount() = listData.size

    override fun onBindViewHolder(viewHolder: NewsViewHolder, position: Int) {
        viewHolder.resource.setImageResource(listData[position].resource)
        viewHolder.name.text = listData[position].name
        viewHolder.discount.text = listData[position].discount
        viewHolder.date.text = listData[position].date
    }

}