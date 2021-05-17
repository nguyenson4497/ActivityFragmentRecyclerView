package com.example.zeplinnewproject.fragment

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.zeplinnewproject.R
import com.example.zeplinnewproject.adapter.AdapterHome
import com.example.zeplinnewproject.adapter.AdapterHomeTop
import com.example.zeplinnewproject.model.HomeObject
import kotlinx.android.synthetic.main.fragment_home.*
import java.util.*

class FragmentHome : Fragment() {
    private var isLoading: Boolean = false
    private var currentPage: Int = 1
    private var mList: MutableList<HomeObject> = mutableListOf()
    private val array = arrayOf(
        "INDEX", "SHARES", "CURRENCIES", "FUTURE", "CRYPTO",
        "INDEX", "SHARES", "CURRENCIES", "FUTURE", "CRYPTO"
    )
    private val menuAdapterHomeTop: AdapterHomeTop = AdapterHomeTop(array)
    private val adapterHome: AdapterHome = AdapterHome()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        iv_alarm.setOnClickListener {
            val rnd = Random()
            val color: Int = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
            iv_alarm.setBackgroundColor(color)
        }

        rv_item_menu_1.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        rv_item_menu_1.adapter = menuAdapterHomeTop

        firstData()
        val linearLayoutItem = LinearLayoutManager(context)
        rv_item_home.layoutManager = linearLayoutItem
        rv_item_home.addItemDecoration(
            DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        )

        rv_item_home.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (dy > 0) {
                    val visibleItemCount: Int = linearLayoutItem.childCount
                    val totalItemCount: Int = linearLayoutItem.itemCount
                    val firstVisibleItemPosition = linearLayoutItem.findFirstVisibleItemPosition()

                    if (firstVisibleItemPosition >= 0 && (visibleItemCount + firstVisibleItemPosition) >= totalItemCount) {
                        isLoading = true
                        button_load.visibility = View.VISIBLE
                        button_load.setOnClickListener {
                            currentPage++
                            Toast.makeText(context, "Update 10 item!", Toast.LENGTH_SHORT).show()
                            add10Item()
                        }
                    }
                } else {
                    button_load.visibility = View.GONE
                }
                if (isLoading) {
                    return
                }
            }
        })
        rv_item_home.adapter = adapterHome

        val itemTouchHelper =
            ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {
                override fun onMove(
                    recyclerView: RecyclerView,
                    viewHolder: RecyclerView.ViewHolder,
                    target: RecyclerView.ViewHolder
                ): Boolean {
                    return false
                }

                override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                    val positionOfData = viewHolder.adapterPosition
                    when (direction) {
                        ItemTouchHelper.RIGHT -> {
                            mList.removeAt(positionOfData)
                            adapterHome.notifyItemRemoved(viewHolder.layoutPosition)
                            Toast.makeText(context, mList[positionOfData].name, Toast.LENGTH_SHORT)
                                .show()
                        }
                    }
                }
            })
        itemTouchHelper.attachToRecyclerView(rv_item_home)
    }

    private fun firstData() {
        mList = getListData()
        adapterHome.setData(mList)
    }

    private fun getListData(): MutableList<HomeObject> {
        val listData: MutableList<HomeObject> = mutableListOf()

        listData.add(HomeObject("DOWN JONES", "NYSE", "10:44:45", "20.047.50", "+203(+1.04%)"))
        listData.add(HomeObject("FTSE 100", "LONDON", "10:44:45", "20.047.50", "+203(1.04%)"))
        listData.add(HomeObject("IBEX 35", "MADRID", "10:44:45", "20.047.50", "+203(1.04%)"))
        listData.add(HomeObject("DAX", "XETRA", "10:44:45", "20.047.50", "+203(1.04%)"))
        listData.add(HomeObject("DOWN JONES", "NYSE", "10:44:45", "20.047.50", "+203(+1.04%)"))
        listData.add(HomeObject("FTSE 100", "LONDON", "10:44:45", "20.047.50", "+203(1.04%)"))
        listData.add(HomeObject("IBEX 35", "MADRID", "10:44:45", "20.047.50", "+203(1.04%)"))
        listData.add(HomeObject("DAX", "XETRA", "10:44:45", "20.047.50", "+203(1.04%)"))
        listData.add(HomeObject("DOWN JONES", "NYSE", "10:44:45", "20.047.50", "+203(+1.04%)"))
        listData.add(HomeObject("FTSE 100", "LONDON", "10:44:45", "20.047.50", "+203(1.04%)"))
        listData.add(HomeObject("IBEX 35", "MADRID", "10:44:45", "20.047.50", "+203(1.04%)"))
        listData.add(HomeObject("DAX", "XETRA", "10:44:45", "20.047.50", "+203(1.04%)"))
        return listData
    }

    companion object {
        const val TAB_HOME: String = "TAB_HOME"
    }

    private fun add10Item() {
        for (i in 1..10) {
            mList.add(HomeObject("DOWN JONES", "NYSE", "10:44:45", "20.047.50", "+203(+1.04%)"))
        }
        adapterHome.setData(mList)
        isLoading = false
        button_load.visibility = View.GONE
    }

}