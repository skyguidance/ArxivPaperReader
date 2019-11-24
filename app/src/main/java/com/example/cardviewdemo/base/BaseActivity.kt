/**
 * Create by Liu,GaoZhi <chrysalisliu@gwu.edu>
 * CSCI 6221 Course Project - Team 15 - Fall 2019. George Washington University.
 * Copyright 2019 - Present
 */
package com.example.cardviewdemo.base

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast


/**
 * Base Activity abstract Class.
 */
abstract class BaseActivity : AppCompatActivity(), AnkoLogger {

    /**
     * Global UID.
     * This is the value to determine which user is logged in.
     * if the Value is 0 or -1 or <empty> means no user logged in.
     */
    var UID: String="1"

    /**
     * Get the current User from the SharedPreferences from Android.
     * And set the UID variable.
     */
    fun getThisUser(): String {
        var pref=this.getSharedPreferences("CurrentUserInfo", Context.MODE_PRIVATE)
        if (pref != null) {
            UID=pref.getString("UID", "")
        } else {
            UID=""
        }
        return UID
    }

    /**
     * On Create Activity.
     * Those Actions will be called when a new activity is launched.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getThisUser()
        setContentView(getLayoutId())
        initListener()
        initData()
    }

    /**
     * Get the Layout ID.
     */
    abstract fun getLayoutId(): Int

    /**
     * Initialize the Data.
     * Override when create a specify Activity.
     */
    open protected fun initData() {

    }

    /**
     * Initialize the Listener.
     * Override when create a specify Activity.
     */
    open protected fun initListener() {

    }

    /**
     * Create for easy Toast.
     */
    protected fun myToast(msg: String) {
        runOnUiThread { toast(msg) }
    }

    /**
     * start an activity and finish it
     */
    inline fun <reified T : BaseActivity> startActivityAndFinish() {
        startActivity<T>()
        finish()
    }


}