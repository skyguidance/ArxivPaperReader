/**
 * Create by Liu,GaoZhi <chrysalisliu@gwu.edu>
 * CSCI 6221 Course Project - Team 15 - Fall 2019. George Washington University.
 * Copyright 2019 - Present
 */
package com.example.cardviewdemo.ui.activity

import android.view.View
import androidx.core.view.ViewCompat
import androidx.core.view.ViewPropertyAnimatorListener
import com.example.cardviewdemo.R
import com.example.cardviewdemo.base.BaseActivity
import kotlinx.android.synthetic.main.activity_splash.*
import org.jetbrains.anko.startActivity

/**
 * The App SplashScreen Activity.
 */
class SplashActivity : BaseActivity(), ViewPropertyAnimatorListener {
    /**
     * Triggered when splash is done.
     */
    override fun onAnimationEnd(view: View?) {
        /**
         * Goto Main Activity.
         */
        startActivityAndFinish<MainActivity>()
    }

    /**
     * Triggered when splash is canceled (unaccepted.)
     */
    override fun onAnimationCancel(view: View?) {

    }

    /**
     * Triggered when splash is start.
     */
    override fun onAnimationStart(view: View?) {

    }

    /**
     * Get the layout ID.
     */
    override fun getLayoutId(): Int {
        return R.layout.activity_splash
    }

    /**
     * Init Data.
     */
    override fun initData() {
        ViewCompat.animate(imageView).scaleX(1.0f).scaleY(1.0f).setListener(this).setDuration(2000)
    }
}