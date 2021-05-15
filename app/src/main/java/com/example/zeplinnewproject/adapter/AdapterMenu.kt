package com.example.zeplinnewproject.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.zeplinnewproject.R
import com.example.zeplinnewproject.model.MenuObject2
import com.example.zeplinnewproject.model.MenuObject1

class AdapterMenu : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var listData: MutableList<Any> = mutableListOf()

    fun setData(listData: MutableList<Any>) {
        this.listData = listData
        notifyDataSetChanged()
    }

    class ViewTypeViewHolder1(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgView1: ImageView = itemView.findViewById(R.id.iv_icon_list_menu_1)
        var textView1: TextView = itemView.findViewById(R.id.tv_icon_list_menu_1)
    }

    class ViewTypeViewHolder2(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgView2: ImageView = itemView.findViewById(R.id.iv_icon_list_menu_2)
        var textView2: TextView = itemView.findViewById(R.id.tv_icon_list_menu_2)

    }

    class ViewTypeViewHolder3(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textView3: TextView = itemView.findViewById(R.id.tv_text_menu_style_3)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            ViewType.TYPE_1.type -> {
                val view: View =
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.item_list_menu, parent, false)
                ViewTypeViewHolder1(view)
            }
            ViewType.TYPE_2.type -> {
                val view: View =
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.item_list_menu_2, parent, false)
                ViewTypeViewHolder2(view)
            }
            else -> {
                val view: View =
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.item_list_menu_3, parent, false)
                ViewTypeViewHolder3(view)
            }
        }
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (getItemViewType(position)) {
            ViewType.TYPE_1.type -> {
                holder as ViewTypeViewHolder1
                holder.imgView1.setImageResource((listData[position] as MenuObject1).resource)
                holder.textView1.text = (listData[position] as MenuObject1).name
            }
            ViewType.TYPE_2.type -> {
                holder as ViewTypeViewHolder2
                holder.imgView2.setImageResource((listData[position] as MenuObject2).resource)
                holder.textView2.text = (listData[position] as MenuObject2).name
            }
            ViewType.TYPE_3.type -> {
                holder as ViewTypeViewHolder3
                holder.textView3.text = listData[position].toString()
            }
        }

    }

    override fun getItemViewType(position: Int): Int {
        return when {
            listData[position] is MenuObject1 -> {
                ViewType.TYPE_1.type
            }
            listData[position] is MenuObject2 -> {
                ViewType.TYPE_2.type
            }
            listData[position] is String -> {
                ViewType.TYPE_3.type
            }
            else -> -1
        }
    }

    enum class ViewType(val type: Int) {
        TYPE_1(0),
        TYPE_2(1),
        TYPE_3(2),
    }
}