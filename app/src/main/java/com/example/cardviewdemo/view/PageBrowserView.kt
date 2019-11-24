/**
 * Create by Qi,TianYi <qitianyi@gwmail.gwu.edu>
 * CSCI 6221 Course Project - Team 15 - Fall 2019. George Washington University.
 * Copyright 2019 - Present
 */
package com.example.cardviewdemo.view

/**
 * Handle Page Browse view and presenter.
 */
interface PageBrowserView {
    /**
     * Handle when API returns.
     */
    fun loadSuccess(cleanPrevious:Int,romeResult: MutableList<List<MutableList<String>>>)

}