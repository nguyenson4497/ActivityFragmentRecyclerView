package com.example.zeplinnewproject.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.zeplinnewproject.R
import com.example.zeplinnewproject.adapter.AdapterNewsTop
import com.example.zeplinnewproject.adapter.AdapterNews
import com.example.zeplinnewproject.model.NewsObject
import kotlinx.android.synthetic.main.fragment_news_1.*

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
        return inflater.inflate(R.layout.fragment_news_1, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        data()
        dataAlready()

        rv_item_news_2.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rv_item_news_2.adapter = adapterNews

        rv_item_news_1.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        rv_item_news_1.adapter = adapterNewsTop
        iv_img_news.setOnClickListener {
            val fragment = FragmentNewsArticle()
            val fragmentTransaction: FragmentTransaction? = fragmentManager?.beginTransaction()
            fragmentTransaction?.replace(R.id.fragment_tab, fragment)?.addToBackStack(TAB_NEWS)
                ?.commit()
        }
        iv_news_back.setOnClickListener{
            fragmentManager?.popBackStack()
        }
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