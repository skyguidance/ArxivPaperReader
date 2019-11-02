package com.example.cardviewdemo.ui.fragment

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cardviewdemo.R
import com.example.cardviewdemo.adapter.HomeAdapter
import com.example.cardviewdemo.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment:BaseFragment() {
    override fun initView(): View? {
        return View.inflate(context, R.layout.fragment_home,null)
    }

    override fun initListener() {
        //initialize recycleView
        recycleView.layoutManager  = LinearLayoutManager(context)

        //adapt
        val adapter = HomeAdapter()
        recycleView.adapter = adapter
    }

}