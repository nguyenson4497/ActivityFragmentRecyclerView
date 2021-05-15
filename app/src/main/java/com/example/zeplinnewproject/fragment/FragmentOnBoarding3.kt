package com.example.zeplinnewproject.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.zeplinnewproject.R
import com.example.zeplinnewproject.activity.LoginActivity
import kotlinx.android.synthetic.main.fragment_on_boarding_3.*

class FragmentOnBoarding3 : Fragment(), View.OnClickListener{
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_on_boarding_3, container, false)
        val btnNext = view.findViewById<TextView>(R.id.tv_button_next_3)
        val btnBack = view.findViewById<ImageView>(R.id.iv_back_3)
        val btnSkip = view.findViewById<TextView>(R.id.tv_skip_3)
        btnNext.setOnClickListener(this)
        btnBack.setOnClickListener(this)
        btnSkip.setOnClickListener(this)
        return view
    }

    override fun onClick(p0: View?) {
        when(p0){
            tv_button_next_3 -> {
                startActivity(Intent(context, LoginActivity::class.java))
            }
            iv_back_3 -> {
                fragmentManager?.popBackStack()
            }
            tv_skip_3 -> {
                startActivity(Intent(context, LoginActivity::class.java))
            }
        }
    }
}