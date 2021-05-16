package com.example.zeplinnewproject.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.zeplinnewproject.R
import com.example.zeplinnewproject.`interface`.TransferData
import com.example.zeplinnewproject.adapter.AdapterHome
import com.example.zeplinnewproject.adapter.MenuAdapter
import com.example.zeplinnewproject.model.HomeObject
import kotlinx.android.synthetic.main.fragment_login.*

class FragmentHome : Fragment() {
    private var isLoading: Boolean = false
    private var currentPage: Int = 1
    private var mList: MutableList<HomeObject> = mutableListOf()
    private val array = arrayOf(
        "INDEX", "SHARES", "CURRENCIES", "FUTURE", "CRYPTO",
        "INDEX", "SHARES", "CURRENCIES", "FUTURE", "CRYPTO"
    )
    private val menuAdapter: MenuAdapter = MenuAdapter(array)
    private val adapterHome: AdapterHome = AdapterHome()
    private lateinit var btnLoad: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        val recyclerMenu = view.findViewById<RecyclerView>(R.id.rv_item_menu_1)
        val recyclerItemHome = view.findViewById<RecyclerView>(R.id.rv_item_home)
        btnLoad = view.findViewById(R.id.button_load)

        recyclerMenu.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recyclerMenu.adapter = menuAdapter

        firstData()
        val linearLayoutItem = LinearLayoutManager(context)
        recyclerItemHome.layoutManager = linearLayoutItem
        recyclerItemHome.addItemDecoration(
            DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        )

        recyclerItemHome.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (dy > 0) {
                    val visibleItemCount: Int = linearLayoutItem.childCount
                    val totalItemCount: Int = linearLayoutItem.itemCount
                    val firstVisibleItemPosition = linearLayoutItem.findFirstVisibleItemPosition()

                    if (firstVisibleItemPosition >= 0 && (visibleItemCount + firstVisibleItemPosition) >= totalItemCount) {
                        isLoading = true
                        btnLoad.visibility = View.VISIBLE
                        btnLoad.setOnClickListener {
                            currentPage++
                            Toast.makeText(context, "Update 10 item!", Toast.LENGTH_SHORT).show()
                            add10Item()
                        }
                    }
                } else {
                    btnLoad.visibility = View.GONE
                }
                if (isLoading) {
                    return
                }
            }
        })
        recyclerItemHome.adapter = adapterHome

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
        itemTouchHelper.attachToRecyclerView(recyclerItemHome)
        return view
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
        mList.add(HomeObject("DOWN JONES 1", "NYSE", "10:44:45", "20.047.50", "+203(+1.04%)"))
        mList.add(HomeObject("DOWN JONES 2", "NYSE", "10:44:45", "20.047.50", "+203(+1.04%)"))
        mList.add(HomeObject("DOWN JONES 3", "NYSE", "10:44:45", "20.047.50", "+203(+1.04%)"))
        mList.add(HomeObject("DOWN JONES 4", "NYSE", "10:44:45", "20.047.50", "+203(+1.04%)"))
        mList.add(HomeObject("DOWN JONES 5", "NYSE", "10:44:45", "20.047.50", "+203(+1.04%)"))
        mList.add(HomeObject("DOWN JONES 6", "NYSE", "10:44:45", "20.047.50", "+203(+1.04%)"))
        mList.add(HomeObject("DOWN JONES 7", "NYSE", "10:44:45", "20.047.50", "+203(+1.04%)"))
        mList.add(HomeObject("DOWN JONES 8", "NYSE", "10:44:45", "20.047.50", "+203(+1.04%)"))
        mList.add(HomeObject("DOWN JONES 9", "NYSE", "10:44:45", "20.047.50", "+203(+1.04%)"))
        mList.add(HomeObject("DOWN JONES 10", "NYSE", "10:44:45", "20.047.50", "+203(+1.04%)"))
        adapterHome.setData(mList)
        isLoading = false
        btnLoad.visibility = View.GONE
    }

}