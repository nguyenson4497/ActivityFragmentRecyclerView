package com.example.zeplinnewproject.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.zeplinnewproject.R
import com.example.zeplinnewproject.`interface`.TransferData
import kotlinx.android.synthetic.main.fragment_sign_up.*

class FragmentSignUp : Fragment(), View.OnClickListener {
    private lateinit var transferData: TransferData
    private lateinit var edtE: EditText
    private lateinit var edtP: EditText

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_sign_up, container, false)

        transferData = activity as TransferData
        edtE = view.findViewById(R.id.edt_email)
        edtP = view.findViewById(R.id.edt_password)

        val btnSignUp = view.findViewById<TextView>(R.id.tv_button_sign_up)
        val btnLogin = view.findViewById<TextView>(R.id.tv_login)
        val btnForgotPassword = view.findViewById<TextView>(R.id.tv_forgot_password_2)

        btnSignUp.setOnClickListener(this)
        btnLogin.setOnClickListener(this)
        btnForgotPassword.setOnClickListener(this)
        return view
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
        transferData.passData(edtE.text.toString(), edtP.text.toString())
    }

    companion object {
        const val SIGN_UP: String = "SIGN_UP"
    }
}