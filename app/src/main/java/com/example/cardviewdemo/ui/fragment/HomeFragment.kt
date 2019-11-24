/**
 * Create by Liu,GaoZhi <chrysalisliu@gwu.edu>
 * CSCI 6221 Course Project - Team 15 - Fall 2019. George Washington University.
 * Copyright 2019 - Present
 */
package com.example.cardviewdemo.ui.fragment

import android.graphics.Color
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cardviewdemo.R
import com.example.cardviewdemo.adapter.HomeAdapter
import com.example.cardviewdemo.base.BaseFragment
import com.example.cardviewdemo.presenter.impl.HomePresenterImpl
import com.example.cardviewdemo.ui.activity.PaperDetailActivity
import com.example.cardviewdemo.view.HomeView
import kotlinx.android.synthetic.main.fragment_home.*
import org.jetbrains.anko.support.v4.startActivity

/**
 * This is the Android Home Fragment.
 */
class HomeFragment : BaseFragment(), HomeView {
    override fun loadSuccess(
        cleanPrevious: Int,
        romeResult: MutableList<List<MutableList<String>>>
    ) {
        refreshLayout?.isRefreshing=false
        adapter.updateList(cleanPrevious, romeResult)
    }

    val adapter by lazy { HomeAdapter() }
    val presenter by lazy { HomePresenterImpl(this) }
    override fun initView(): View? {
        return View.inflate(context, R.layout.fragment_home, null)
    }

    override fun initListener() {
        //initialize recycleView
        recycleView.layoutManager=LinearLayoutManager(context)
        //adapt
        recycleView.adapter=adapter
        //initialize swipeRefresh
        refreshLayout.setColorSchemeColors(Color.RED)
        refreshLayout.setOnRefreshListener {
            //Listen on refresh
            presenter.loadDatas()
        }
        // listen to the swap
        recycleView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {

            }

            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    val layoutManager=recyclerView.layoutManager
                    if (layoutManager is LinearLayoutManager) {
                        val manager: LinearLayoutManager=layoutManager
                        val lastPosition=manager.findLastVisibleItemPosition()
                        if (lastPosition == adapter.itemCount - 1) {
                            // is the last one
                            presenter.loadMore(adapter.itemCount - 1)
                        }
                    }
                }
            }

        })

        adapter.setMyListener {
            startActivity<PaperDetailActivity>("item" to it)
        }
    }


    override fun initData() {
        presenter.loadDatas()
    }


}