package com.example.cardviewdemo.presenter.impl

import com.example.cardviewdemo.presenter.interf.FavoritePresenter
import com.example.cardviewdemo.util.ArxivRequest
import com.example.cardviewdemo.util.ThreadUtil
import com.example.cardviewdemo.view.FavoriteView

class FavoritePresenterImpl(var favoriteView: FavoriteView ) : FavoritePresenter {
    // Load data and Refresh data
    override fun loadDatas() {
        Thread({
            val requestArxiv = ArxivRequest()
            val result = requestArxiv.Rome(0, "", "")
            ThreadUtil.runOnMainThread(object : Runnable {
                override fun run() {
                    // return to homeView

                    favoriteView.loadSuccess(1, result)
                }
            })
        }).start()
    }

    override fun loadMore(offset: Int) {
        Thread({
            val requestArxiv = ArxivRequest()
            val result = requestArxiv.Rome(offset, "", "")
            ThreadUtil.runOnMainThread(object : Runnable {
                override fun run() {
                    favoriteView.loadSuccess(0, result)

                }
            })
        }).start()
    }

}