package com.example.cardviewdemo.ui.fragment

import android.view.View
import com.example.cardviewdemo.R
import com.example.cardviewdemo.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_register.view.*

class RegisterFragment : BaseFragment(){

    fun newInstance(): RegisterFragment {
        return RegisterFragment()
    }

    override fun initView(): View? {

        var view = View.inflate(context, R.layout.fragment_register, null)

        view.btn_register_register.setOnClickListener {
            fragmentManager?.beginTransaction()?.addToBackStack(null)
                ?.replace(R.id.container,LoginFragment())?.commit()
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