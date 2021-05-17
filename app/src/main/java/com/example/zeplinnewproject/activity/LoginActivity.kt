package com.example.zeplinnewproject.activity

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.zeplinnewproject.R
import com.example.zeplinnewproject.`interface`.TransferData
import com.example.zeplinnewproject.fragment.*

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
        val fragmentLogin = FragmentLogin()
        fragmentLogin.arguments = bundle
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame_account, fragmentLogin)
        transaction.commit()
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 0) {
            when (supportFragmentManager.getBackStackEntryAt(supportFragmentManager.backStackEntryCount - 1).name) {
                FragmentEmail.EMAIL -> {
                    supportFragmentManager.popBackStack()
                }
                FragmentSignUp.SIGN_UP -> {
                    supportFragmentManager.popBackStack()
                }
                FragmentLogin.LOGIN ->{
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