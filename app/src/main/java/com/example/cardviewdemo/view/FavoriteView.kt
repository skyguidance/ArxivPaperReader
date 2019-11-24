/**
 * Create by Wu,Hang <hwu91@gwmail.gwu.edu>
 * CSCI 6221 Course Project - Team 15 - Fall 2019. George Washington University.
 * Copyright 2019 - Present
 */
package com.example.cardviewdemo.view

/**
 * Handle Favourite view and presenter.
 */
interface FavoriteView {
    /**
     * Handle when API returns.
     */
    fun loadSuccess(cleanPrevious:Int,romeResult: MutableList<List<MutableList<String>>>)

}