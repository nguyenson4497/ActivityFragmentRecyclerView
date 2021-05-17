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
import kotlinx.android.synthetic.main.fragment_confirm_password_changed.*

class FragmentConfirmPassword: Fragment(), View.OnClickListener {
    private lateinit var transferData: TransferData
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_confirm_password_changed, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        tv_button_login_confirm.setOnClickListener(this)
        transferData = activity as TransferData
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