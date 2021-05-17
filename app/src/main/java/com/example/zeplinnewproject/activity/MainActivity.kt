package com.example.zeplinnewproject.activity

import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import com.example.zeplinnewproject.R
import com.example.zeplinnewproject.fragment.FragmentOnBoarding1
import com.example.zeplinnewproject.fragment.FragmentOnBoarding2

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startApp()
    }

    private fun startApp() {
        val fragmentTransaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        val fragmentOnBoarding1 = FragmentOnBoarding1()
        fragmentTransaction.replace(R.id.frame, fragmentOnBoarding1)
        fragmentTransaction.commit()
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 0) {
            when (supportFragmentManager.getBackStackEntryAt(supportFragmentManager.backStackEntryCount - 1).name) {
                FragmentOnBoarding2.TUTORIAL_2 -> {
                    supportFragmentManager.popBackStack()
                }
                FragmentOnBoarding1.TUTORIAL_1 -> {
                    supportFragmentManager.popBackStack()
                }
            }
        } else {
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

