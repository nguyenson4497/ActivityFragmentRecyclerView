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
import kotlinx.android.synthetic.main.fragment_email.*

class FragmentEmail : Fragment(), View.OnClickListener {
    private lateinit var loginAct: LoginActivity
    private var number = 30
    private val handler = Handler()
    private var isRevertRunning = false
    private lateinit var countDownToZero: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_email, container, false)
        countDownToZero = view.findViewById(R.id.tv_count_down)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        loginAct = activity as LoginActivity
        tv_button_resend_email.setOnClickListener(this)
        countDown()
    }

    override fun onClick(p0: View?) {
        updateNumber()
        val fragmentTransaction: FragmentTransaction? = fragmentManager?.beginTransaction()
        val fragment = FragmentConfirmPassword()
        fragmentTransaction?.replace(R.id.frame_account, fragment)
        fragmentTransaction?.addToBackStack(EMAIL)?.commit()
    }

    private fun countDown() {
        handler.postDelayed({
            isRevertRunning = true
            Thread {
                while (isRevertRunning) {
                    Thread.sleep(1000)
                    if (number == 0) {
                        isRevertRunning = false
                        val fragmentTransaction: FragmentTransaction? =
                            fragmentManager?.beginTransaction()
                        val fragment = FragmentConfirmPassword()
                        fragmentTransaction?.replace(R.id.frame_account, fragment)
                            ?.addToBackStack(EMAIL)?.commit()
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
        countDownToZero.text = "Wait $number seconds before sending it"
    }

    private fun updateNumber() {
        isRevertRunning = false
        number = 31
    }

    companion object {
        const val EMAIL: String = "EMAIL"
    }
}