package com.example.zeplinnewproject.activity

import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import com.example.zeplinnewproject.R
import com.example.zeplinnewproject.fragment.*
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
                fragmentTransaction.addToBackStack(FragmentCoin.TAB_COIN)
                fragmentTransaction.commit()
            }
            iv_news -> {
                val fragment = FragmentNews()
                val fragmentTransaction: FragmentTransaction =
                    supportFragmentManager.beginTransaction()
                fragmentTransaction.replace(R.id.fragment_tab, fragment)
                fragmentTransaction.addToBackStack(FragmentNews.TAB_NEWS)
                fragmentTransaction.commit()
            }
            iv_customer -> {
                val fragment = FragmentMenu()
                val fragmentTransaction: FragmentTransaction =
                    supportFragmentManager.beginTransaction()
                fragmentTransaction.replace(R.id.fragment_tab, fragment)
                fragmentTransaction.commit()
            }
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        if (supportFragmentManager.backStackEntryCount > 0) {
            when (supportFragmentManager.getBackStackEntryAt(supportFragmentManager.backStackEntryCount - 1).name) {
                FragmentNews.TAB_NEWS -> {
                    supportFragmentManager.popBackStack()
                }
                FragmentCoin.TAB_COIN ->{
                    supportFragmentManager.popBackStack()
                }
                FragmentNewsArticle.TAB_ARTICLE ->{
                    supportFragmentManager.popBackStack()
                }
            }
        } else{
            exitApp()
        }

    }

    private fun exitApp(){
        val alertDialog = AlertDialog.Builder(this)
        alertDialog.setTitle("Exit Application")
        alertDialog.setIcon(R.drawable.alert)
        alertDialog.setMessage("Bạn có muốn thoát ứng dụng?")
            .setCancelable(false)
            .setPositiveButton("Có") { _, _ -> finish() }
            .setNegativeButton("Không") { dialog, _ -> dialog.cancel() }
        val builder = alertDialog.create()
        builder.show()
    }
}