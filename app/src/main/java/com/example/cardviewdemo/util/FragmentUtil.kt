/**
 * Create by Liu,GaoZhi <chrysalisliu@gwu.edu>
 * CSCI 6221 Course Project - Team 15 - Fall 2019. George Washington University.
 * Copyright 2019 - Present
 */
package com.example.cardviewdemo.util

import com.example.cardviewdemo.R
import com.example.cardviewdemo.base.BaseFragment
import com.example.cardviewdemo.ui.fragment.AccountFragment
import com.example.cardviewdemo.ui.fragment.HomeFragment
import com.example.cardviewdemo.ui.fragment.SearchFragment

/**
 * The Fragment Manager for the Main Activity.
 */
class FragmentUtil private constructor() {

    /**
     * Lazy load all fragment(s).
     */
    val homeFragment by lazy { HomeFragment() }
    val searchFragment by lazy { SearchFragment() }
    val accountFragment by lazy { AccountFragment() }

    companion object {
        val fragmentUtil by lazy { FragmentUtil() }
    }

    /**
     * Get fragment by TabID.
     */
    fun getFragment(tabId: Int): BaseFragment {
        when (tabId) {
            R.id.tab_home -> return homeFragment
            R.id.tab_search -> return searchFragment
            R.id.tab_account -> return accountFragment
        }
        return searchFragment
    }
}