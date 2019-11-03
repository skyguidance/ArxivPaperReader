package com.example.cardviewdemo.ui.fragment

import android.graphics.Color
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
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
        refreshLayout.setOnRefreshListener {
            //Listen on refresh
            loadDatas()
        }
        // listen to the swap
        recycleView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {

            }

            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    val layoutManager = recyclerView.layoutManager
                    if (layoutManager is LinearLayoutManager) {
                        val manager: LinearLayoutManager = layoutManager
                        val lastPosition = manager.findLastVisibleItemPosition()
                        if (lastPosition == adapter.itemCount - 1) {
                            // is the last one
                            loadMore(adapter.itemCount - 1)
                        }
                    }
                }
            }

        })
    }

    override fun initData() {
        loadDatas()
    }

    private fun loadDatas() {
        Thread({
            val requestArxiv = ArxivRequest()
            val result = requestArxiv.Rome(0, "cs.AI")
            ThreadUtil.runOnMainThread(object : Runnable {
                override fun run() {
                    refreshLayout.isRefreshing = false
                    adapter.updateList(1, result)
                }
            })
        }).start()
    }

    private fun loadMore(offset: Int) {
        Thread({
            val requestArxiv = ArxivRequest()
            val result = requestArxiv.Rome(offset, "cs.AI")
            ThreadUtil.runOnMainThread(object : Runnable {
                override fun run() {
                    refreshLayout.isRefreshing = false
                    adapter.updateList(0, result)
                }
            })
        }).start()
    }

}