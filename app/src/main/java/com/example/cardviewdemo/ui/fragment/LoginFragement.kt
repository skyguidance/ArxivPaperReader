package com.example.cardviewdemo.ui.fragment

import SettingsFragement
import android.view.View
import com.example.cardviewdemo.R
import com.example.cardviewdemo.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_login.view.*
import org.json.JSONException
import java.io.IOException

class LoginFragment : BaseFragment(){

    fun newInstance(): LoginFragment {
        return LoginFragment()
    }

    override fun initView(): View? {

        var view = View.inflate(context, R.layout.fragment_login, null)

        view.tv_login_register.setOnClickListener {
            fragmentManager?.beginTransaction()?.addToBackStack(null)
                ?.replace(R.id.container,SettingsFragement())?.commit()
        }
        view.tv_login_register.setOnClickListener {
            fragmentManager?.beginTransaction()?.addToBackStack(null)
                ?.replace(R.id.container,RegisterFragment())?.commit()
        }
        return view;


    }


    @Throws(IOException::class, JSONException::class)
    private fun login() {
        try {
            //mainwork
        } catch (e: Exception) {

        } finally {

        }
    }
}