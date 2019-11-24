/**
 * Create by Qi,TianYi <qitianyi@gwmail.gwu.edu>
 * CSCI 6221 Course Project - Team 15 - Fall 2019. George Washington University.
 * Copyright 2019 - Present
 */
package com.example.cardviewdemo.ui.fragment

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.SearchView
import com.example.cardviewdemo.R
import com.example.cardviewdemo.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_search.*
import kotlinx.android.synthetic.main.fragment_search.view.*

/**
 * This class implement the basic search fragment.
 * The Search Function is the normal search.(Which only use keywords to find paper.)
 */
class SearchFragment : BaseFragment() {
    /**
     * Create View.
     */
    override fun initView(): View? {
        var view=View.inflate(context, R.layout.fragment_search, null)
        view.button_advanced_search.setOnClickListener {
            fragmentManager?.beginTransaction()?.addToBackStack(null)
                ?.replace(R.id.container, AdvancedSearchFragment())?.commit()
        }
        view.search_view.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextChange(p0: String?): Boolean {
                return false
            }

            override fun onQueryTextSubmit(p0: String?): Boolean {
                var frag=PaperBrowseFragment()
                var item=Bundle()
                item.putString("SearchWord", p0)
                item.putString("Category", "")
                frag.setArguments(item)
                fragmentManager?.beginTransaction()?.addToBackStack(null)
                    ?.replace(R.id.container, frag)?.commit()
                return false
            }
        })
        return view;
    }

    /**
     * Init Data.
     */
    override fun initData() {

    }

}