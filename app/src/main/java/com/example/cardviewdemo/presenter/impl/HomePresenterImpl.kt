/**
 * Create by Qi,TianYi <qitianyi@gwmail.gwu.edu>
 * CSCI 6221 Course Project - Team 15 - Fall 2019. George Washington University.
 * Copyright 2019 - Present
 */
package com.example.cardviewdemo.presenter.impl

import com.example.cardviewdemo.presenter.interf.HomePresenter
import com.example.cardviewdemo.util.ArxivRequest
import com.example.cardviewdemo.util.ThreadUtil
import com.example.cardviewdemo.view.HomeView
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * Article Card View Presenter Implementation. (MPV)
 */
class HomePresenterImpl(var homeView: HomeView) : HomePresenter {
    /**
     * Load data and Refresh data
     */
    override fun loadDatas() {
        Thread({
            val requestArxiv=ArxivRequest()
            val result=requestArxiv.Rome(0, "", "")
            ThreadUtil.runOnMainThread(object : Runnable {
                override fun run() {
                    homeView.loadSuccess(1, result)
                }
            })
        }).start()
    }

    /**
     * Load more when hit the bottom.
     */
    override fun loadMore(offset: Int) {
        Thread({
            val requestArxiv=ArxivRequest()
            val result=requestArxiv.Rome(offset, "", "")
            ThreadUtil.runOnMainThread(object : Runnable {
                override fun run() {
                    homeView.loadSuccess(0, result)
                }
            })
        }).start()
    }

}