package com.example.cardviewdemo.view


interface PageBrowserView {

    fun loadSuccess(cleanPrevious:Int,romeResult: MutableList<List<MutableList<String>>>)

}