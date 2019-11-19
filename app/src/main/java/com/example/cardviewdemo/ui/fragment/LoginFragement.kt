package com.example.cardviewdemo.ui.fragment

import SettingsFragement
import android.content.Context
import android.view.View
import com.example.cardviewdemo.R
import com.example.cardviewdemo.api.mysql.UserLogin
import com.example.cardviewdemo.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_login.view.*
import org.jetbrains.anko.support.v4.runOnUiThread
import org.json.JSONException
import java.io.IOException

class LoginFragment : BaseFragment() {

    fun newInstance(): LoginFragment {
        return LoginFragment()
    }

    override fun initView(): View? {

        var view=View.inflate(context, R.layout.fragment_login, null)

        view.tv_login_register.setOnClickListener {
            fragmentManager?.beginTransaction()?.addToBackStack(null)
                ?.replace(R.id.container, SettingsFragement())?.commit()
        }
        view.tv_login_register.setOnClickListener {
            fragmentManager?.beginTransaction()?.addToBackStack(null)
                ?.replace(R.id.container, RegisterFragment())?.commit()
        }
        view.btn_login_login.setOnClickListener {
            login()
        }
        return view;


    }

    fun setThisUser(currentUID: String) {
        var pref=this.activity?.getSharedPreferences("CurrentUserInfo", Context.MODE_PRIVATE)
        var editor=pref?.edit()
        if (editor != null) {
            editor.putString("UID", currentUID)
            editor.apply()
        }
    }


    @Throws(IOException::class, JSONException::class)
    private fun login() {
        try {
            val username=et_login_username.text.toString()
            val password=et_login_password.text.toString()
            Thread({
                val result=UserLogin.doUserLogin(username, password)
                if (result == -1) {
                    runOnUiThread {
                        myToast("Username or password mismatch.")
                    }
                } else {
                    runOnUiThread {
                        println("DEBUG:doUserLogin:CurrentUser:" + result)
                       // myToast("Login Success." + result)
                        setThisUser(result.toString())
                        fragmentManager?.beginTransaction()?.addToBackStack(null)
                            ?.replace(R.id.container,AccountFragmentLogin())?.commit()
                    }
                }
            }).start()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}