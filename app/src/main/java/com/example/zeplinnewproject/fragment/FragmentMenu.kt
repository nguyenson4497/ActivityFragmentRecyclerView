package com.example.zeplinnewproject.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.zeplinnewproject.R
import com.example.zeplinnewproject.adapter.AdapterMenu
import com.example.zeplinnewproject.model.MenuObject1
import com.example.zeplinnewproject.model.MenuObject2

class FragmentMenu : Fragment() {
    private var listData: MutableList<Any> = mutableListOf()
    private val menuAdapterMenu: AdapterMenu = AdapterMenu()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_menu, container, false)
        dataAlready()
        menuAdapterMenu.setData(listData)
        val recycler1 = view.findViewById<RecyclerView>(R.id.rv_list_menu)
        recycler1.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        recycler1.adapter = menuAdapterMenu
        val back = view.findViewById<ImageView>(R.id.iv_menu_back)
        back.setOnClickListener {
            fragmentManager?.popBackStack()
        }

        return view
    }

    private fun dataAlready() {
        listData.add(MenuObject1(R.drawable.icons_8_alarm, "Alerts"))
        listData.add(MenuObject1(R.drawable.icons_8_left_and_right_arrows, "Predictions"))
        listData.add(MenuObject1(R.drawable.icons_8_pin, "Saved elements"))
        listData.add(MenuObject1(R.drawable.icons_8_no_entry, "Remove Ads"))

        listData.add("Tools")

        listData.add(MenuObject2(R.drawable.icons_8_profit_2, "Select Stocks"))
        listData.add(MenuObject2(R.drawable.icons_8_swap, "Currency Exchange"))
        listData.add(MenuObject2(R.drawable.icons_8_video_call, "Webinar"))
        listData.add(MenuObject2(R.drawable.icons_8_rent, "Best Broker"))

        listData.add("Market")

        listData.add(MenuObject2(R.drawable.icons_8_profit_2, "Select Stocks"))
        listData.add(MenuObject2(R.drawable.icons_8_swap, "Currency Exchange"))
        listData.add(MenuObject2(R.drawable.icons_8_video_call, "Webinar"))
        listData.add(MenuObject2(R.drawable.icons_8_rent, "Best Broker"))
    }
}