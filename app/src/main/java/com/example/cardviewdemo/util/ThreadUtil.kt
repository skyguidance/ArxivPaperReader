/**
 * Create by Liu,GaoZhi <chrysalisliu@gwu.edu>
 * CSCI 6221 Course Project - Team 15 - Fall 2019. George Washington University.
 * Copyright 2019 - Present
 */
package com.example.cardviewdemo.util

import android.os.Handler
import android.os.Looper

/**
 * The Thread Utility.
 * Control the Code Fragment to run on specific Thread.
 */
object ThreadUtil {
    val handler = Handler(Looper.getMainLooper())
    /**
     * Run the code on the main thread.
     */
    fun runOnMainThread(runnable: Runnable) {
        handler.post(runnable)
    }
}