package com.example.cardviewdemo.ui.fragment

import android.graphics.Color
import android.view.Gravity
import android.view.View
import android.widget.TextView
import com.example.cardviewdemo.R
import com.example.cardviewdemo.base.BaseFragment
import kotlinx.android.synthetic.main.activity_main.*

class AccountFragment : BaseFragment(){
    fun newInstance(): AccountFragment {
        return AccountFragment()
    }

    override fun initView(): View? {

        return inflater.inflate(R.layout.fragment_account, container, false)
    }

}