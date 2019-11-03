package com.example.cardviewdemo.view

/**
 * Handle home view and presenter.
 */

interface HomeView {

    fun loadSuccess(cleanPrevious:Int,romeResult: MutableList<List<MutableList<String>>>)

}