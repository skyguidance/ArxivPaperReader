package com.example.cardviewdemo.presenter.impl

import com.example.cardviewdemo.presenter.interf.HomePresenter
import com.example.cardviewdemo.presenter.interf.PageBrowsePresenter
import com.example.cardviewdemo.util.ArxivRequest
import com.example.cardviewdemo.util.ThreadUtil
import com.example.cardviewdemo.view.HomeView
import com.example.cardviewdemo.view.PageBrowserView

class PageBrowsePresenterImpl(var pageBrowserView: PageBrowserView) : PageBrowsePresenter {
    // Load data and Refresh data
    override fun loadDatas(cat: String, searchWord: String) {
        Thread({
            val requestArxiv = ArxivRequest()
            val result = requestArxiv.Rome(0,searchWord, cat)
            ThreadUtil.runOnMainThread(object : Runnable {
                override fun run() {
                    // return to homeView
                    pageBrowserView.loadSuccess(1, result)
                }
            })
        }).start()
    }

    override fun loadMore(offset: Int, cat: String, searchWord: String) {
        Thread({
            val requestArxiv = ArxivRequest()
            val result = requestArxiv.Rome(offset,searchWord, cat)
            ThreadUtil.runOnMainThread(object : Runnable {
                override fun run() {
                    pageBrowserView.loadSuccess(0, result)

                }
            })
        }).start()
    }

}