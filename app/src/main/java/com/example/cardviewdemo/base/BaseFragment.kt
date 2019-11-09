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

//All fragments' base class
abstract class BaseFragment: Fragment(), AnkoLogger {

    var UID: String = ""

    fun getThisUser():String{
        var pref = this.activity?.getSharedPreferences("CurrentUserInfo", Context.MODE_PRIVATE)
        if (pref != null) {
            UID = pref.getString("UID", "")
        }else{
            UID = ""
        }
        println("DEBUG:GETUID:"+UID)
        return UID
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    //fragment initialize
    protected fun init() {

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        getThisUser()
        return initView()
    }

    //get layout view
    abstract fun initView(): View?

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initListener()
        initData()
    }

    //data initialize
    open protected fun initData() {

    }

    //adapter listener
    open protected fun initListener() {

    }

    fun myToast(msg: String){
        context?.runOnUiThread { toast(msg) }
    }


}