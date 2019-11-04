package com.example.cardviewdemo.presenter.interf

interface PageBrowsePresenter {
    fun loadDatas(cat: String, searchWord: String)
    abstract fun loadMore(offset: Int, cat: String, searchWord: String)
}