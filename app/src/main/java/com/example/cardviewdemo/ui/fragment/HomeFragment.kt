package com.example.cardviewdemo.ui.fragment

import android.graphics.Color
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cardviewdemo.R
import com.example.cardviewdemo.adapter.HomeAdapter
import com.example.cardviewdemo.base.BaseFragment
import com.example.cardviewdemo.util.ArxivRequest
import com.example.cardviewdemo.util.ThreadUtil
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : BaseFragment() {


    val adapter by lazy { HomeAdapter() }

    override fun initView(): View? {
        return View.inflate(context, R.layout.fragment_home, null)
    }

    override fun initListener() {
        //initialize recycleView
        recycleView.layoutManager = LinearLayoutManager(context)
        //adapt
        recycleView.adapter = adapter
        //initialize swipeRefresh
        refreshLayout.setColorSchemeColors(Color.RED)
        refreshLayout.setOnRefreshListener{
            //Listen on refresh
            loadDatas()
        }
    }

    override fun initData() {
        loadDatas()
    }

    private fun loadDatas() {
        Thread({
            val requestArxiv = ArxivRequest()
            val result = requestArxiv.Rome(10, "cs.AI")
            ThreadUtil.runOnMainThread(object : Runnable {
                override fun run() {
                    refreshLayout.isRefreshing = false
                    adapter.updateList(result)
                }
            })
        }).start()

    }

}