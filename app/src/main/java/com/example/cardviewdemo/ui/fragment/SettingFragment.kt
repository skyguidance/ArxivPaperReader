package com.example.cardviewdemo.ui.fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import com.example.cardviewdemo.R
import com.example.cardviewdemo.ui.activity.AboutActivity


class SettingFragment : PreferenceFragmentCompat() {
    fun setThisUser(currentUID: String) {
        var pref = this.activity?.getSharedPreferences("CurrentUserInfo", Context.MODE_PRIVATE)
        var editor = pref?.edit()
        if (editor != null) {
            editor.putString("UID", currentUID)
            editor.apply()
        }
    }

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.setting, rootKey)
    }

    override fun onPreferenceTreeClick(preference: Preference?): Boolean {
        val key = preference?.key
        if("about".equals(key)){
            //click "About"
            activity?.startActivity(Intent(activity, AboutActivity::class.java))
        }
        return super.onPreferenceTreeClick(preference)
    }
}