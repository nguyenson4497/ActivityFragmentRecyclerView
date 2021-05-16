package com.example.zeplinnewproject.fragment

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.zeplinnewproject.R
import com.example.zeplinnewproject.`interface`.TransferData
import com.example.zeplinnewproject.activity.HomeActivity
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_login.*
import java.util.*

class FragmentLogin : Fragment(), View.OnClickListener {
    private var displayEmail: String? = ""
    private var displayPassword: String? = ""
    private lateinit var edtEmail: EditText
    private lateinit var edtPassword: EditText
    private lateinit var transferData: TransferData

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)
        val btnSignUp = view.findViewById<TextView>(R.id.tv_sign_up)
        val btnLogin = view.findViewById<TextView>(R.id.tv_button_login_1)
        val btnForgotPassword = view.findViewById<TextView>(R.id.tv_forgot_password_1)
        edtEmail = view.findViewById(R.id.edt_email_1)
        edtPassword = view.findViewById(R.id.edt_password_1)
        btnSignUp.setOnClickListener(this)
        btnLogin.setOnClickListener(this)
        btnForgotPassword.setOnClickListener(this)
        transferData = activity as TransferData

        displayEmail = arguments?.getString("mess1")
        displayPassword = arguments?.getString("mess2")
        receiveDataFromSignUp()
        return view
    }

    override fun onClick(p0: View?) {
        when (p0) {
            tv_sign_up -> {
                val fragmentTransaction: FragmentTransaction? = fragmentManager?.beginTransaction()
                val fragment = FragmentSignUp()
                fragmentTransaction?.replace(R.id.frame_account, fragment)
                fragmentTransaction?.addToBackStack(LOGIN)
                fragmentTransaction?.commit()
            }
            tv_forgot_password_1 -> {
                val fragmentTransaction: FragmentTransaction? = fragmentManager?.beginTransaction()
                val fragment = FragmentEmail()
                fragmentTransaction?.replace(R.id.frame_account, fragment)
                fragmentTransaction?.addToBackStack(LOGIN)
                fragmentTransaction?.commit()
            }
            tv_button_login_1 -> {
                if (edtEmail.text.isEmpty() || edtPassword.text.isEmpty()) {
                    Toast.makeText(
                        this.context,
                        "Vui lòng điền đầy đủ thông tin",
                        Toast.LENGTH_SHORT
                    ).show()
                    return
                }
                startActivity(Intent(this.context, HomeActivity::class.java))
            }
        }
    }

    companion object {
        const val LOGIN: String = "LOGIN"
    }

    private fun receiveDataFromSignUp() {
        edtEmail.setText(displayEmail)
        edtPassword.setText(displayPassword)
    }

}