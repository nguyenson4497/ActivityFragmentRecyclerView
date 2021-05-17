package com.example.zeplinnewproject.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.zeplinnewproject.R
import com.example.zeplinnewproject.activity.LoginActivity
import com.example.zeplinnewproject.activity.MainActivity
import kotlinx.android.synthetic.main.fragment_on_boarding_3.*

class FragmentOnBoarding3 : Fragment(), View.OnClickListener {
    private lateinit var mMainActivity: MainActivity

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_on_boarding_3, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mMainActivity = activity as MainActivity
        tv_button_next_3.setOnClickListener(this)
        tv_skip_3.setOnClickListener(this)
        iv_back_3.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when (p0) {
            tv_button_next_3 -> {
                startActivity(Intent(context, LoginActivity::class.java))
                mMainActivity.finish()
            }
            iv_back_3 -> {
                fragmentManager?.popBackStack()
            }
            tv_skip_3 -> {
                startActivity(Intent(context, LoginActivity::class.java))
                mMainActivity.finish()
            }
        }
    }
}