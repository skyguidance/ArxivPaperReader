/**
 * Create by Hang,Wu <hwu91@gwu.edu>
 * CSCI 6221 Course Project - Team 15 - Fall 2019. George Washington University.
 * Copyright 2019 - Present
 */
package com.example.cardviewdemo.ui.fragment

import android.view.View
import com.example.cardviewdemo.R
import com.example.cardviewdemo.api.mysql.UserRegister
import com.example.cardviewdemo.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_register.view.*
/**
 * This is the Register fragment.
 * The register page is presented in this fragment.
 */
class RegisterFragment : BaseFragment(){
    /**
     * Create Register Fragment.
     */
    fun newInstance(): RegisterFragment {
        return RegisterFragment()
    }

    override fun initView(): View? {

        var view = View.inflate(context, R.layout.fragment_register, null)

        view.btn_register_register.setOnClickListener {

            try {
                Thread({
                    var s1 = view.et_register_username!!.text.toString()
                    var s2 = view.et_register_password!!.text.toString()
                    UserRegister.doUserRegister(s1,s2)
                }).start()
                fragmentManager?.beginTransaction()?.addToBackStack(null)
                    ?.replace(R.id.container,LoginFragment())?.commit()
            } catch (e: Exception) {
                e.printStackTrace()
            }

        }
        view.tv_register_login.setOnClickListener {
            fragmentManager?.beginTransaction()?.addToBackStack(null)
                ?.replace(R.id.container,LoginFragment())?.commit()
        }
        return view;
    }


//    @Throws(IOException::class, JSONException::class)
//    private fun login() {
//        try {
//            //mainwork
//        } catch (e: Exception) {
//
//        } finally {
//
//        }
//    }
}