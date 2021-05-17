package com.example.zeplinnewproject.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.zeplinnewproject.R
import com.example.zeplinnewproject.adapter.AdapterArticle
import com.example.zeplinnewproject.adapter.AdapterNewsTop
import kotlinx.android.synthetic.main.fragment_news_2.*

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
        return inflater.inflate(R.layout.fragment_news_2, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        dataArticle()
        rv_news_article.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rv_news_article.adapter = adapterArticle

        dataTop()
        rv_item_news_3.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        rv_item_news_3.adapter = adapterNewsTop

        iv_img_news_2.setOnClickListener(this)
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