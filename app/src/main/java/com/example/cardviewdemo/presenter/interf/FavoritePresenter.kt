package com.example.cardviewdemo.presenter.interf

interface FavoritePresenter {
    fun loadDatas(UID: Int)
    abstract fun loadMore(offset: Int, UID: Int)
}