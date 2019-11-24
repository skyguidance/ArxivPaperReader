/**
 * Create by Qi,TianYi <qitianyi@gwmail.gwu.edu>
 * CSCI 6221 Course Project - Team 15 - Fall 2019. George Washington University.
 * Copyright 2019 - Present
 */
package com.example.cardviewdemo.presenter.impl

import com.example.cardviewdemo.presenter.interf.HomePresenter
import com.example.cardviewdemo.presenter.interf.PageBrowsePresenter
import com.example.cardviewdemo.util.ArxivRequest
import com.example.cardviewdemo.util.ThreadUtil
import com.example.cardviewdemo.view.HomeView
import com.example.cardviewdemo.view.PageBrowserView

/**
 * Article Card View Presenter Implementation. (MPV)
 */
class PageBrowsePresenterImpl(var pageBrowserView: PageBrowserView) : PageBrowsePresenter {
    /**
     * Load data and Refresh data
     */
    override fun loadDatas(cat: String, searchWord: String) {
        Thread({
            val requestArxiv=ArxivRequest()
            val result=requestArxiv.Rome(0, searchWord, cat)
            ThreadUtil.runOnMainThread(object : Runnable {
                override fun run() {
                    pageBrowserView.loadSuccess(1, result)
                }
            })
        }).start()
    }

    /**
     * Load more when hit the bottom.
     */
    override fun loadMore(offset: Int, cat: String, searchWord: String) {
        Thread({
            val requestArxiv=ArxivRequest()
            val result=requestArxiv.Rome(offset, searchWord, cat)
            ThreadUtil.runOnMainThread(object : Runnable {
                override fun run() {
                    pageBrowserView.loadSuccess(0, result)

                }
            })
        }).start()
    }

}