package com.example.zeplinnewproject.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.zeplinnewproject.R
import com.example.zeplinnewproject.activity.LoginActivity
import kotlinx.android.synthetic.main.fragment_on_boarding_1.*

class FragmentOnBoarding1 : Fragment(), View.OnClickListener {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_on_boarding_1, container, false)
        val btnNext = view.findViewById<TextView>(R.id.tv_button_next_1)
        val btnSkip = view.findViewById<TextView>(R.id.tv_skip_1)
        btnNext.setOnClickListener(this)
        btnSkip.setOnClickListener(this)
        return view
    }

    override fun onClick(p0: View?) {
        when(p0){
            tv_button_next_1 -> {
                val fragment = FragmentOnBoarding2()
                val fragmentTransaction: FragmentTransaction? = fragmentManager?.beginTransaction()
                fragmentTransaction?.replace(R.id.frame, fragment)
                fragmentTransaction?.addToBackStack(TUTORIAL_1)
                fragmentTransaction?.commit()
            }
            tv_skip_1 -> {
                startActivity(Intent(context, LoginActivity::class.java))
            }
        }
    }

    companion object{
        const val TUTORIAL_1: String = "TUTORIAL_1"
    }
}