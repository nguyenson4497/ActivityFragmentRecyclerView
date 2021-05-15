package com.example.zeplinnewproject.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.zeplinnewproject.R

class AdapterArticle: RecyclerView.Adapter<AdapterArticle.ArticleViewHolder>() {
    private var listData: Array<String> = arrayOf()
    class ArticleViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.tv_article)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ArticleViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_news_article, viewGroup, false)
        return ArticleViewHolder(view)
    }

    override fun getItemCount() = listData.size

    override fun onBindViewHolder(viewHolder: ArticleViewHolder, position: Int) {
        viewHolder.textView.text = listData[position]
    }

    fun setData(listData: Array<String>) {
        this.listData = listData
        notifyDataSetChanged()
    }
}