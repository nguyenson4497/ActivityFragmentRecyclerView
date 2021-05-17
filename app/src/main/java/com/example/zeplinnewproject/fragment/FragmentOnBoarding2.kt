package com.example.zeplinnewproject.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.zeplinnewproject.R
import com.example.zeplinnewproject.activity.LoginActivity
import com.example.zeplinnewproject.activity.MainActivity
import kotlinx.android.synthetic.main.fragment_on_boarding_2.*

class FragmentOnBoarding2 : Fragment(), View.OnClickListener {
    private lateinit var mMainActivity: MainActivity

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_on_boarding_2, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mMainActivity = activity as MainActivity
        tv_skip_2.setOnClickListener(this)
        tv_button_next_2.setOnClickListener(this)
        iv_back_2.setOnClickListener(this)
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
                mMainActivity.finish()
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