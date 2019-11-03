package com.example.cardviewdemo.util

import android.os.Handler
import android.os.Looper

object ThreadUtil {
    val handler = Handler(Looper.getMainLooper())
    /**
     * Run the code on the main thread.
     */
    fun runOnMainThread(runnable: Runnable) {
        handler.post(runnable)
    }
}