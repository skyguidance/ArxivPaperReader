package com.example.cardviewdemo.presenter.impl

import com.example.cardviewdemo.presenter.interf.HomePresenter
import com.example.cardviewdemo.util.ArxivRequest
import com.example.cardviewdemo.util.ThreadUtil
import com.example.cardviewdemo.view.HomeView
import kotlinx.android.synthetic.main.fragment_home.*

class HomePresenterImpl(var homeView:HomeView):HomePresenter{
    // Load data and Refresh data
    override fun loadDatas() {
        Thread({
            val requestArxiv = ArxivRequest()
            val result = requestArxiv.Rome(0, "cs.AI")
            ThreadUtil.runOnMainThread(object : Runnable {
                override fun run() {
                    // return to homeView
                    homeView.loadSuccess(1, result)
                }
            })
        }).start()
    }

    override fun loadMore(offset: Int) {
        Thread({
            val requestArxiv = ArxivRequest()
            val result = requestArxiv.Rome(offset, "cs.AI")
            ThreadUtil.runOnMainThread(object : Runnable {
                override fun run() {
                    homeView.loadSuccess(0, result)

                }
            })
        }).start()
    }

}