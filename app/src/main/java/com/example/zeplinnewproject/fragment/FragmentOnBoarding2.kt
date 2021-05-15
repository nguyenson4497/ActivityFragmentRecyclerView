package com.example.zeplinnewproject.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.zeplinnewproject.R
import com.example.zeplinnewproject.activity.LoginActivity
import kotlinx.android.synthetic.main.fragment_on_boarding_2.*

class FragmentOnBoarding2 : Fragment(), View.OnClickListener {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_on_boarding_2, container, false)
        val btnNext = view.findViewById<TextView>(R.id.tv_button_next_2)
        val btnSkip = view.findViewById<TextView>(R.id.tv_skip_2)
        val btnBack = view.findViewById<ImageView>(R.id.iv_back_2)
        btnNext.setOnClickListener(this)
        btnSkip.setOnClickListener(this)
        btnBack.setOnClickListener(this)
        return view
    }

    override fun onClick(p0: View?) {
        when (p0) {
            tv_button_next_2 -> {
                val fragment = FragmentOnBoarding3()
                val fragmentTransaction: FragmentTransaction? = fragmentManager?.beginTransaction()
                fragmentTransaction?.replace(R.id.frame, fragment)
                fragmentTransaction?.addToBackStack(TUTORIAL_2)
                fragmentTransaction?.commit()
            }
            tv_skip_2 -> {
                startActivity(Intent(context, LoginActivity::class.java))
            }
            iv_back_2 -> {
                fragmentManager?.popBackStack()
            }
        }
    }

    companion object{
        const val TUTORIAL_2: String = "TUTORIAL_2"
    }
}