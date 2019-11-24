/**
 * Create by Liu,GaoZhi <chrysalisliu@gwu.edu>
 * CSCI 6221 Course Project - Team 15 - Fall 2019. George Washington University.
 * Copyright 2019 - Present
 */
package com.example.cardviewdemo.ui.activity

import androidx.appcompat.widget.Toolbar
import com.example.cardviewdemo.R
import com.example.cardviewdemo.base.BaseActivity
import com.example.cardviewdemo.util.FragmentUtil
import com.example.cardviewdemo.util.ToolBarManager
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.find

/**
 * This is the Android Home Page Main Activity.
 */
class MainActivity : BaseActivity(), ToolBarManager {
    /**
     * Lazy Load.
     */
    override val toolbar: Toolbar by lazy { find<Toolbar>(R.id.toolbar) }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initData() {
        initMainToolBar()
    }

    /**
     * tab switch listener
     */
    override fun initListener() {
        bottomBar.setOnTabSelectListener {
            val transaction=supportFragmentManager.beginTransaction()
            transaction.replace(
                R.id.container,
                FragmentUtil.fragmentUtil.getFragment(it),
                it.toString()
            )
            transaction.commit()
        }
    }


}
