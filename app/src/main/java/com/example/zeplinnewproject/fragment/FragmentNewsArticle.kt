package com.example.zeplinnewproject.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.zeplinnewproject.R
import com.example.zeplinnewproject.adapter.AdapterArticle
import com.example.zeplinnewproject.adapter.AdapterNewsTop

class FragmentNewsArticle : Fragment(), View.OnClickListener {
    private var list: Array<String> = arrayOf(
        "EDITORIAL", "CRYPTO NEWS", "RAW MATERIAL", "ECONOMIC",
        "EDITORIAL", "CRYPTO NEWS", "RAW MATERIAL", "ECONOMIC"
    )

    private var article: Array<String> = arrayOf(
        "Rem deserunt voluptatem sapiente. Quod sint officiis ",
        "quae magnam. Qui eaque atque quia. Incidunt dolor",
        "reiciendis tenetur libero error consequatur voluptate",
        "recusandae. Sequi voluptatum quas. Ullam voluptatem",
        "reprehenderit ea commodi. Doloremque autem",
        "praesentium qui harum quia sunt voluptatem eius at.",
        "Voluptates voluptatem eaque et voluptas maxime",
        "molestiae et. Et saepe perferendis ut quidem et est. Et",
        "iusto ut nostrum delectus. Libero et modi placeat",
        "labore sit et quaerat sed. Dolorem libero earum ipsum",
        "illum nemo.",
        "Rem deserunt voluptatem sapiente. Quod sint officiis ",
        "quae magnam. Qui eaque atque quia. Incidunt dolor",
        "reiciendis tenetur libero error consequatur voluptate",
        "recusandae. Sequi voluptatum quas. Ullam voluptatem",
        "reprehenderit ea commodi. Doloremque autem",
        "praesentium qui harum quia sunt voluptatem eius at.",
        "Voluptates voluptatem eaque et voluptas maxime",
        "molestiae et. Et saepe perferendis ut quidem et est. Et",
        "iusto ut nostrum delectus. Libero et modi placeat",
        "labore sit et quaerat sed. Dolorem libero earum ipsum",
        "illum nemo."
    )
    private var adapterNewsTop = AdapterNewsTop()
    private var adapterArticle = AdapterArticle()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_news_2, container, false)
        val back = view.findViewById<ImageView>(R.id.iv_news_back)
        back.setOnClickListener(this)

        dataArticle()
        val recyclerArticle = view.findViewById<RecyclerView>(R.id.rv_news_article)
        recyclerArticle.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        recyclerArticle.adapter = adapterArticle

        dataTop()
        val recyclerTop = view.findViewById<RecyclerView>(R.id.rv_item_news_3)
        recyclerTop.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recyclerTop.adapter = adapterNewsTop

        return view
    }

    private fun dataTop() {
        adapterNewsTop.setData(list)
    }

    private fun dataArticle() {
        adapterArticle.setData(article)
    }

    override fun onClick(p0: View?) {
        fragmentManager?.popBackStack()
    }

}