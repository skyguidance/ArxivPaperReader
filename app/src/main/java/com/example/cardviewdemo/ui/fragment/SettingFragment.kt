/**
 * Create by Liu,GaoZhi <chrysalisliu@gwu.edu>
 * CSCI 6221 Course Project - Team 15 - Fall 2019. George Washington University.
 * Copyright 2019 - Present
 */
package com.example.cardviewdemo.ui.fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import com.example.cardviewdemo.R
import com.example.cardviewdemo.ui.activity.AboutActivity

/**
 * This is the Settings Fragment.
 */
class SettingFragment : PreferenceFragmentCompat() {
    /**
     * Get User Settings Perferences.
     */
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.setting, rootKey)
    }

    /**
     * On Click Listener.
     */
    override fun onPreferenceTreeClick(preference: Preference?): Boolean {
        val key=preference?.key
        if ("about".equals(key)) {
            /**
             * click "About"
             */
            activity?.startActivity(Intent(activity, AboutActivity::class.java))
        }
        return super.onPreferenceTreeClick(preference)
    }
}