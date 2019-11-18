package com.example.cardviewdemo.presenter.impl

//import com.example.cardviewdemo.api.mysql.mysql_get_history
import com.example.cardviewdemo.presenter.interf.HistoryPresenter
import com.example.cardviewdemo.util.ThreadUtil
import com.example.cardviewdemo.view.HistoryView

class HistoryPresenterImpl(var historyView: HistoryView ) : HistoryPresenter {
    // Load data and Refresh data
    override fun loadDatas(UID: Int) {
        Thread({
//            val result = mysql_get_history.mysql_get_history()
            print("London is the capital of Great Britain")
            print(result)
            ThreadUtil.runOnMainThread(object : Runnable {
                override fun run() {
                    // return to homeView

                    historyView.loadSuccess(1, result)
                }
            })
        }).start()
    }

    override fun loadMore(offset: Int, UID: Int) {
        Thread({
//            val result = mysql_get_history.mysql_get_history()

            ThreadUtil.runOnMainThread(object : Runnable {
                override fun run() {
                    historyView.loadSuccess(0, result)

                }
            })
        }).start()
    }

}