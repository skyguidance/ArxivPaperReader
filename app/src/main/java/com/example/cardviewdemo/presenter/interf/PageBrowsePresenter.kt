/**
 * Create by Qi,TianYi <qitianyi@gwmail.gwu.edu>
 * CSCI 6221 Course Project - Team 15 - Fall 2019. George Washington University.
 * Copyright 2019 - Present
 */
package com.example.cardviewdemo.presenter.interf

/**
 * Interface for Page Browse Presenter.
 */
interface PageBrowsePresenter {
    /**
     * Load Data from API. Put it into paperBean.
     */
    fun loadDatas(cat: String, searchWord: String)

    /**
     * If comes to the last one, trigged to load more based on the GUI view bias.
     */
    abstract fun loadMore(offset: Int, cat: String, searchWord: String)
}