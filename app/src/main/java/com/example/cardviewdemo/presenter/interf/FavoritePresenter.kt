package com.example.cardviewdemo.presenter.interf

interface FavoritePresenter {
    fun loadDatas()
    abstract fun loadMore(offset: Int)
}