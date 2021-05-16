package com.example.zeplinnewproject.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import com.example.zeplinnewproject.R
import com.example.zeplinnewproject.fragment.FragmentCoin
import com.example.zeplinnewproject.fragment.FragmentHome
import com.example.zeplinnewproject.fragment.FragmentMenu
import com.example.zeplinnewproject.fragment.FragmentNews
import kotlinx.android.synthetic.main.bottom_bar.*

class HomeActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        goToMainApp()
        initViews()
    }

    private fun initViews() {
        iv_increase.setOnClickListener(this)
        iv_chart.setOnClickListener(this)
        iv_news.setOnClickListener(this)
        iv_customer.setOnClickListener(this)
    }

    private fun goToMainApp() {
        val fragment = FragmentHome()
        val fragmentTransaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_tab, fragment)
        fragmentTransaction.addToBackStack(FragmentHome.TAB_HOME)
        fragmentTransaction.commit()
    }

    override fun onClick(p0: View?) {
        when (p0) {
            iv_increase -> {
                val fragment = FragmentHome()
                val fragmentTransaction: FragmentTransaction =
                    supportFragmentManager.beginTransaction()
                fragmentTransaction.replace(R.id.fragment_tab, fragment)
                fragmentTransaction.commit()
            }
            iv_chart -> {
                val fragment = FragmentCoin()
                val fragmentTransaction: FragmentTransaction =
                    supportFragmentManager.beginTransaction()
                fragmentTransaction.replace(R.id.fragment_tab, fragment)
                fragmentTransaction.addToBackStack(FragmentHome.TAB_HOME)
                fragmentTransaction.addToBackStack(FragmentCoin.TAB_COIN)
                fragmentTransaction.commit()
            }
            iv_news -> {
                val fragment = FragmentNews()
                val fragmentTransaction: FragmentTransaction =
                    supportFragmentManager.beginTransaction()
                fragmentTransaction.replace(R.id.fragment_tab, fragment)
                fragmentTransaction.addToBackStack(FragmentHome.TAB_HOME)
                fragmentTransaction.addToBackStack(FragmentNews.TAB_NEWS)
                fragmentTransaction.commit()
            }
            iv_customer -> {
                val fragment = FragmentMenu()
                val fragmentTransaction: FragmentTransaction =
                    supportFragmentManager.beginTransaction()
                fragmentTransaction.replace(R.id.fragment_tab, fragment)
                fragmentTransaction.addToBackStack(FragmentHome.TAB_HOME)
                fragmentTransaction.commit()
            }
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        if (iv_chart.isFocusable){
            supportFragmentManager.popBackStack(FragmentHome.TAB_HOME, 1)
        }
    }

}