package com.example.cardviewdemo.presenter.interf

interface HistoryPresenter {
    fun loadDatas(UID: Int)
    abstract fun loadMore(offset: Int, UID: Int)
}