/**
 * Create by Hang,Wu <hwu91@gwu.edu>
 * CSCI 6221 Course Project - Team 15 - Fall 2019. George Washington University.
 * Copyright 2019 - Present
 */
package com.example.cardviewdemo.ui.fragment

import CreditFragement
import FavoriteFragement
import HistoryFragement
import android.content.Context
import android.view.View
import com.example.cardviewdemo.R
import com.example.cardviewdemo.api.mysql.getUserName
import com.example.cardviewdemo.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_account.view.btn_credit
import kotlinx.android.synthetic.main.fragment_account.view.tv_userid
import kotlinx.android.synthetic.main.fragment_account_login.*
import kotlinx.android.synthetic.main.fragment_account_login.view.*
import org.jetbrains.anko.support.v4.runOnUiThread
/**
 * This is the Account login fragment.
 * Accounts' login page is presented in this fragment.
 */
class AccountFragmentLogin : BaseFragment() {
    /**
     * Create User AccountLogin Fragment.
     */
    fun newInstance(): AccountFragmentLogin {
        return AccountFragmentLogin()
    }

    override fun initView(): View? {
        if (getThisUser().equals("") or getThisUser().equals("-1")) {
            fragmentManager?.beginTransaction()?.addToBackStack(null)
                ?.replace(R.id.container, AccountFragment())?.commit()
        }

        var view=View.inflate(context, R.layout.fragment_account_login, null)

        view.btn_favorites.setOnClickListener {
            fragmentManager?.beginTransaction()?.addToBackStack(null)
                ?.replace(R.id.container, FavoriteFragement())?.commit()
        }
        view.btn_history.setOnClickListener {
            fragmentManager?.beginTransaction()?.addToBackStack(null)
                ?.replace(R.id.container, HistoryFragement())?.commit()
        }
//        view.btn_settings.setOnClickListener {
//            if (isRegistered()) {
//                fragmentManager?.beginTransaction()?.addToBackStack(null)
//                    ?.replace(R.id.container, LoginFragment())?.commit()
//            } else {
//                fragmentManager?.beginTransaction()?.addToBackStack(null)
//                    ?.replace(R.id.container, SettingsFragement())?.commit()
//            }
//        }
        view.btn_credit.setOnClickListener {
            fragmentManager?.beginTransaction()?.addToBackStack(null)
                ?.replace(R.id.container, CreditFragement())?.commit()
        }

        view.btn_Logout.setOnClickListener {
            logout()
        }
        //myToast(UID)
        view.tv_userid.setText("UID: " + UID)
        Thread({
            var thisUserName=getUserName.doGetUserName(UID)
            runOnUiThread {
                tv_username.setText(thisUserName)
            }
        }).start()
        return view;
    }

    private fun setThisUser(currentUID: String) {
        var pref=this.activity?.getSharedPreferences("CurrentUserInfo", Context.MODE_PRIVATE)
        var editor=pref?.edit()
        if (editor != null) {
            editor.putString("UID", currentUID)
            editor.apply()
        }
    }

    private fun logout() {
        setThisUser("")
        fragmentManager?.beginTransaction()?.addToBackStack(null)
            ?.replace(R.id.container, AccountFragment())?.commit()
    }

}