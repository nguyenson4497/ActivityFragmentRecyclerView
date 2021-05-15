package com.example.zeplinnewproject.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.zeplinnewproject.R
import com.example.zeplinnewproject.activity.LoginActivity

class FragmentEmail : Fragment(), View.OnClickListener {
    private lateinit var loginAct: LoginActivity
    private var number = 30
    private val handler = Handler()
    private var isRevertRunning = false
    private lateinit var textView: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_email, container, false)
        loginAct = activity as LoginActivity
        textView = view.findViewById(R.id.tv_count_down)
        val btnResend = view.findViewById<TextView>(R.id.tv_button_resend_email)
        btnResend.setOnClickListener(this)
        countDown()
        return view
    }

    override fun onClick(p0: View?) {
        updateNumber()
        val fragmentTransaction: FragmentTransaction = fragmentManager!!.beginTransaction()
        val fragment = FragmentConfirmPassword()
        fragmentTransaction.replace(R.id.frame_account, fragment)
        fragmentTransaction.addToBackStack(EMAIL).commit()
    }

    private fun countDown() {
        handler.postDelayed({
            isRevertRunning = true
            Thread {
                while (isRevertRunning) {
                    Thread.sleep(1000)
                    if (number == 0) {
                        isRevertRunning = false
                        val fragmentTransaction: FragmentTransaction =
                            fragmentManager!!.beginTransaction()
                        val fragment = FragmentConfirmPassword()
                        fragmentTransaction.replace(R.id.frame_account, fragment).addToBackStack(
                            EMAIL
                        ).commit()
                        break
                    } else {
                        loginAct.runOnUiThread {
                            change()
                        }
                    }
                }
            }.start()
        }, 1000)
    }

    @SuppressLint("SetTextI18n")
    private fun change() {
        number--
        textView.text = "Wait $number seconds before sending it"
    }

    private fun updateNumber() {
        isRevertRunning = false
        number = 30
    }

    companion object {
        const val EMAIL: String = "EMAIL"
    }
}