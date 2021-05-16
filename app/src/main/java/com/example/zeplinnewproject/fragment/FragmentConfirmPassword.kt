package com.example.zeplinnewproject.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.zeplinnewproject.R
import com.example.zeplinnewproject.`interface`.TransferData

class FragmentConfirmPassword: Fragment(), View.OnClickListener {
    private lateinit var transferData: TransferData

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_confirm_password_changed, container, false)
        val btnLogin = view.findViewById<TextView>(R.id.tv_button_login_confirm)
        btnLogin.setOnClickListener(this)

        return view
    }

    override fun onClick(p0: View?) {
        val fragmentTransaction: FragmentTransaction? = fragmentManager?.beginTransaction()
        val fragment = FragmentLogin()
        fragmentTransaction?.replace(R.id.frame_account, fragment)
        sendDataToFragmentLogin()
    }

    private fun sendDataToFragmentLogin() {
        transferData.passData("son", "123")
    }
}