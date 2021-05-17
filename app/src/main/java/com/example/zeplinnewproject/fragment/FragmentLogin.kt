package com.example.zeplinnewproject.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.zeplinnewproject.R
import com.example.zeplinnewproject.`interface`.TransferData
import com.example.zeplinnewproject.activity.HomeActivity
import com.example.zeplinnewproject.activity.LoginActivity
import kotlinx.android.synthetic.main.fragment_login.*

class FragmentLogin : Fragment(), View.OnClickListener {
    private var displayEmail: String? = ""
    private var displayPassword: String? = ""
    private lateinit var transferData: TransferData
    private lateinit var mLogin: LoginActivity

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mLogin = activity as LoginActivity
        transferData = activity as TransferData
        displayEmail = arguments?.getString("mess1")
        displayPassword = arguments?.getString("mess2")
        receiveDataFromSignUp()
        tv_sign_up.setOnClickListener(this)
        tv_button_login_1.setOnClickListener(this)
        tv_forgot_password_1.setOnClickListener(this)
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
                if (edt_email_1.text.isEmpty() || edt_password_1.text.isEmpty()) {
                    Toast.makeText(
                        this.context,
                        "Vui lòng điền đầy đủ thông tin",
                        Toast.LENGTH_SHORT
                    ).show()
                    return
                }
                startActivity(Intent(this.context, HomeActivity::class.java))
                Toast.makeText(context, "Đăng nhập thành công", Toast.LENGTH_SHORT).show()
                mLogin.finish()
            }
        }
    }

    companion object {
        const val LOGIN: String = "LOGIN"
    }

    private fun receiveDataFromSignUp() {
        edt_email_1.setText(displayEmail)
        edt_password_1.setText(displayPassword)
    }

}