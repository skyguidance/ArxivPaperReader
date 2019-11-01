package com.example.cardviewdemo.util

import com.example.cardviewdemo.R
import com.example.cardviewdemo.base.BaseFragment
import com.example.cardviewdemo.ui.fragment.AccountFragment
import com.example.cardviewdemo.ui.fragment.HomeFragment
import com.example.cardviewdemo.ui.fragment.SearchFragment

//manage fragments
class FragmentUtil private constructor(){

    val homeFragment by lazy { HomeFragment() }
    val searchFragment by lazy { SearchFragment() }
    val accountFragment by lazy { AccountFragment() }

    companion object {
        val fragmentUtil by lazy { FragmentUtil() }
    }

    //get fragment by tabid
    fun getFragment(tabId:Int): BaseFragment{
        when(tabId){
            R.id.tab_home ->return homeFragment
            R.id.tab_search ->return searchFragment
            R.id.tab_account ->return accountFragment
        }
        return searchFragment
    }
}