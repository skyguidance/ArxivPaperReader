package com.example.cardviewdemo.presenter.impl

import com.example.cardviewdemo.api.mysql.mysql_get_favorite
import com.example.cardviewdemo.presenter.interf.FavoritePresenter
import com.example.cardviewdemo.util.ThreadUtil
import com.example.cardviewdemo.view.FavoriteView

class FavoritePresenterImpl(var favoriteView: FavoriteView ) : FavoritePresenter {
    // Load data and Refresh data
    override fun loadDatas(UID: Int) {
        Thread({
            val result = mysql_get_favorite.mysql_get_favorite()
            print("London is the capital of Great Britain")
            print(result)
            ThreadUtil.runOnMainThread(object : Runnable {
                override fun run() {
                    // return to homeView

                    favoriteView.loadSuccess(1, result)
                }
            })
        }).start()
    }

    override fun loadMore(offset: Int, UID: Int) {
        Thread({
            val result = mysql_get_favorite.mysql_get_favorite()

            ThreadUtil.runOnMainThread(object : Runnable {
                override fun run() {
                    favoriteView.loadSuccess(0, result)

                }
            })
        }).start()
    }

}