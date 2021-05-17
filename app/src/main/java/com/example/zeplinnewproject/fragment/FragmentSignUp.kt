package com.example.zeplinnewproject.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.zeplinnewproject.R
import com.example.zeplinnewproject.`interface`.TransferData
import kotlinx.android.synthetic.main.fragment_sign_up.*

class FragmentSignUp : Fragment(), View.OnClickListener {
    private lateinit var transferData: TransferData

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_sign_up, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        transferData = activity as TransferData
        tv_button_sign_up.setOnClickListener(this)
        tv_login.setOnClickListener(this)
        tv_forgot_password_2.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when (p0) {
            tv_button_sign_up -> {
                if (edt_email.text.isEmpty() || edt_password.text.isEmpty()) {
                    Toast.makeText(context, "Yêu cầu nhập đủ thông tin đăng ký", Toast.LENGTH_SHORT).show()
                    return
                }
                val fragmentTransaction: FragmentTransaction? = fragmentManager?.beginTransaction()
                val fragment = FragmentLogin()
                fragmentTransaction?.replace(R.id.frame_account, fragment)
                fragmentTransaction?.addToBackStack(null)
                fragmentTransaction?.commit()
                sendDataToFragmentLogin()
            }
            tv_login -> {
                val fragmentTransaction: FragmentTransaction? = fragmentManager?.beginTransaction()
                val fragment = FragmentLogin()
                fragmentTransaction?.replace(R.id.frame_account, fragment)
                fragmentTransaction?.addToBackStack(SIGN_UP)
                fragmentTransaction?.commit()
            }
            tv_forgot_password_2 -> {
                val fragmentTransaction: FragmentTransaction? = fragmentManager?.beginTransaction()
                val fragment = FragmentEmail()
                fragmentTransaction?.replace(R.id.frame_account, fragment)
                fragmentTransaction?.addToBackStack(SIGN_UP)
                fragmentTransaction?.commit()
            }
        }
    }

    private fun sendDataToFragmentLogin() {
        transferData.passData(edt_email.text.toString(), edt_password.text.toString())
    }

    companion object {
        const val SIGN_UP: String = "SIGN_UP"
    }
}