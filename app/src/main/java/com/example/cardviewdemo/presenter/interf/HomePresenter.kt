package com.example.cardviewdemo.presenter.interf

interface HomePresenter {
    fun loadDatas()
    abstract fun loadMore(offset: Int)
}