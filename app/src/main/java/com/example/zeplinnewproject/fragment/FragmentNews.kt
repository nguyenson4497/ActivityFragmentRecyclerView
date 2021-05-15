package com.example.zeplinnewproject.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.zeplinnewproject.R
import com.example.zeplinnewproject.adapter.AdapterNewsTop
import com.example.zeplinnewproject.adapter.AdapterNews
import com.example.zeplinnewproject.model.NewsObject

class FragmentNews : Fragment() {
    private lateinit var mList: MutableList<NewsObject>
    private val list: Array<String> = arrayOf(
        "EDITORIAL", "CRYPTO NEWS", "RAW MATERIAL", "ECONOMIC",
        "EDITORIAL", "CRYPTO NEWS", "RAW MATERIAL", "ECONOMIC"
    )
    private val adapterNews: AdapterNews = AdapterNews()
    private val adapterNewsTop = AdapterNewsTop()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_news_1, container, false)

        val recyclerItem = view.findViewById<RecyclerView>(R.id.rv_item_news_2)
        recyclerItem.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        recyclerItem.adapter = adapterNews

        val recyclerTop = view.findViewById<RecyclerView>(R.id.rv_item_news_1)
        recyclerTop.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recyclerTop.adapter = adapterNewsTop

        val image = view.findViewById<ImageView>(R.id.iv_img_news)
        image.setOnClickListener {
            val fragment = FragmentNewsArticle()
            val fragmentTransaction: FragmentTransaction? = fragmentManager?.beginTransaction()
            fragmentTransaction?.replace(R.id.fragment_tab, fragment)?.addToBackStack(TAB_NEWS)
                ?.commit()
        }

        val back = view.findViewById<ImageView>(R.id.iv_news_back)
        back.setOnClickListener{
            fragmentManager?.popBackStack()
        }

        data()
        dataAlready()
        return view
    }

    private fun data() {
        mList = getListData()
        adapterNews.setData(mList)
    }

    private fun dataAlready() {
        adapterNewsTop.setData(list)
    }

    private fun getListData(): MutableList<NewsObject> {
        val list: MutableList<NewsObject> = mutableListOf()

        list.add(NewsObject(R.drawable.image_iphone, "ATLANTIA", "ALT -3,87%", "3 Sept 2020"))
        list.add(NewsObject(R.drawable.image_xiaomi, "XIAOMI", "HKD -2,13%", "2 Sept 2020"))
        list.add(NewsObject(R.drawable.image_iphone, "APPLE", "AAPL -0,91%", "1 Sept 2020"))

        list.add(NewsObject(R.drawable.image_iphone, "ATLANTIA", "ALT -3,87%", "3 Sept 2020"))
        list.add(NewsObject(R.drawable.image_xiaomi, "XIAOMI", "HKD -2,13%", "2 Sept 2020"))
        list.add(NewsObject(R.drawable.image_iphone, "APPLE", "AAPL -0,91%", "1 Sept 2020"))

        list.add(NewsObject(R.drawable.image_iphone, "ATLANTIA", "ALT -3,87%", "3 Sept 2020"))
        list.add(NewsObject(R.drawable.image_xiaomi, "XIAOMI", "HKD -2,13%", "2 Sept 2020"))
        list.add(NewsObject(R.drawable.image_iphone, "APPLE", "AAPL -0,91%", "1 Sept 2020"))
        return list
    }

    companion object {
        const val TAB_NEWS: String = "NEWS"
    }
}