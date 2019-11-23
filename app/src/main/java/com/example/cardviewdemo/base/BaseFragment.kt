/**
 * Create by Liu,GaoZhi <chrysalisliu@gwu.edu>
 * CSCI 6221 Course Project - Team 15 - Fall 2019. George Washington University.
 * Copyright 2019 - Present
 */
package com.example.cardviewdemo.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.runOnUiThread
import org.jetbrains.anko.support.v4.toast

/**
 * Base Fragment abstract Class.
 */
abstract class BaseFragment : Fragment(), AnkoLogger {

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
        var pref=this.activity?.getSharedPreferences("CurrentUserInfo", Context.MODE_PRIVATE)
        if (pref != null) {
            UID=pref.getString("UID", "")
        } else {
            UID=""
        }
        return UID
    }

    /**
     * Check if the user is logged in.
     * Return True is logged in.
     */
    fun isRegistered(): Boolean {
        var pref=this.activity?.getSharedPreferences("CurrentUserInfo", Context.MODE_PRIVATE)
        return (pref != null)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    /**
     * On Create View. Do Get user.
     */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        getThisUser()
        return initView()
    }

    /**
     * Init View.
     */
    abstract fun initView(): View?

    /**
     * Activity Created.
     */
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initListener()
        initData()
    }

    /**
     * Init Data.
     */
    open protected fun initData() {

    }

    /**
     * Init Listener.
     */
    open protected fun initListener() {

    }

    /**
     * Create for easy Toast.
     */
    fun myToast(msg: String) {
        context?.runOnUiThread { toast(msg) }
    }
}