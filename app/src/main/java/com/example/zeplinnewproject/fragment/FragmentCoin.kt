package com.example.zeplinnewproject.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.zeplinnewproject.R
import com.example.zeplinnewproject.adapter.MenuAdapter

class FragmentCoin : Fragment() {
    private val menuData = arrayOf(
        "General", "Technical Section", "Markets", "Chart",
        "General", "Technical Section", "Markets", "Chart"
    )
    private val coinAdapter = MenuAdapter(menuData)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_coin, container, false)

        val btnReturn = view.findViewById<ImageView>(R.id.iv_return)
        btnReturn.setOnClickListener {
            fragmentManager?.popBackStack()
        }

        val recyclerCoin = view.findViewById<RecyclerView>(R.id.rv_coin_menu)
        recyclerCoin.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recyclerCoin.adapter = coinAdapter

        return view
    }

    companion object {
        const val TAB_COIN: String = "TAB_COIN"
    }
}