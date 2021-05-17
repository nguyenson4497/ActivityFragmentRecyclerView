package com.example.zeplinnewproject.fragment

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.zeplinnewproject.R
import com.example.zeplinnewproject.adapter.AdapterHomeTop
import kotlinx.android.synthetic.main.action_bar_coin.*
import kotlinx.android.synthetic.main.fragment_coin.*
import java.util.*

class FragmentCoin : Fragment() {
    private val menuData = arrayOf(
        "General", "Technical Section", "Markets", "Chart",
        "General", "Technical Section", "Markets", "Chart"
    )
    private val coinAdapter = AdapterHomeTop(menuData)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_coin, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        iv_alarm_2.setOnClickListener {
            val rnd = Random()
            val color: Int = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
            iv_alarm_2.setBackgroundColor(color)
        }

        iv_return.setOnClickListener{
            fragmentManager?.popBackStack()
        }

        rv_coin_menu.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        rv_coin_menu.adapter = coinAdapter
    }

    companion object {
        const val TAB_COIN: String = "TAB_COIN"
    }
}