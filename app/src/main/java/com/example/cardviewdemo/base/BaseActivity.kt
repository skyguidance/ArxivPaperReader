package com.example.cardviewdemo.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast


//All activities' base class
abstract class BaseActivity: AppCompatActivity(), AnkoLogger {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        initListener()
        initData()
    }

    //get layout id
    abstract fun getLayoutId(): Int

    //Initialize data
    open protected fun initData(){

    }

    //adapter listener
    open protected fun initListener() {

    }

    protected fun myToast(msg:String){
        runOnUiThread { toast(msg) }
    }

    //start an activity and finish it
    inline fun <reified T:BaseActivity>startActivityAndFinish(){
        startActivity<T>()
        finish()
    }


}