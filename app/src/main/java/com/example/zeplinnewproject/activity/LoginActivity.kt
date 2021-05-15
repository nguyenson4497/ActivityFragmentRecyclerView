package com.example.zeplinnewproject.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.zeplinnewproject.R
import com.example.zeplinnewproject.`interface`.TransferData
import com.example.zeplinnewproject.fragment.FragmentConfirmPassword
import com.example.zeplinnewproject.fragment.FragmentLogin

class LoginActivity : AppCompatActivity(), TransferData {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        startLogin()
    }

    private fun startLogin() {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        val fragmentLogin = FragmentLogin()
        fragmentTransaction.replace(R.id.frame_account, fragmentLogin)
        fragmentTransaction.commit()
    }

    override fun passData(email: String, password: String) {
        val bundle = Bundle()
        bundle.putString("mess1", email)
        bundle.putString("mess2", password)

        val transaction = supportFragmentManager.beginTransaction()
        val fragmentLogin = FragmentLogin()
        val fragmentConfirmPassword = FragmentConfirmPassword()
        fragmentLogin.arguments = bundle
        fragmentConfirmPassword.arguments = bundle

        transaction.replace(R.id.frame_account, fragmentLogin)
        transaction.commit()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        supportFragmentManager.popBackStack()
    }
}