/**
 * Create by Wu,Hang <hwu91@gwmail.gwu.edu>
 * CSCI 6221 Course Project - Team 15 - Fall 2019. George Washington University.
 * Copyright 2019 - Present
 */
package com.example.cardviewdemo.presenter.impl

import com.example.cardviewdemo.api.mysql.mysql_get_favorite
import com.example.cardviewdemo.api.mysql.mysql_search_history
import com.example.cardviewdemo.presenter.interf.HistoryPresenter
import com.example.cardviewdemo.util.ThreadUtil
import com.example.cardviewdemo.view.HistoryView

/**
 * Article Card View Presenter Implementation. (MPV)
 */
class HistoryPresenterImpl(var historyView: HistoryView) : HistoryPresenter {
    /**
     * Load data and Refresh data
     */
    override fun loadDatas(UID: Int) {
        Thread({
            val result=mysql_search_history.mysql_search_history(UID)
            ThreadUtil.runOnMainThread(object : Runnable {
                override fun run() {
                    historyView.loadSuccess(1, result)
                }
            })
        }).start()
    }

    /**
     * Load more when hit the bottom.
     */
    override fun loadMore(offset: Int, UID: Int) {
        Thread({
            val result=mysql_get_favorite.mysql_get_favorite(UID)
            ThreadUtil.runOnMainThread(object : Runnable {
                override fun run() {
                    historyView.loadSuccess(0, result)

                }
            })
        }).start()
    }

}