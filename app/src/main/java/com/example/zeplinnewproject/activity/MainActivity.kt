package com.example.zeplinnewproject.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import com.example.zeplinnewproject.R
import com.example.zeplinnewproject.fragment.FragmentOnBoarding1

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
        super.onBackPressed()
        supportFragmentManager.popBackStack()
    }
}