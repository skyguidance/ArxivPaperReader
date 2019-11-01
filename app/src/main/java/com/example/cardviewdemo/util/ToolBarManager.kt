package com.example.cardviewdemo.util

import android.content.Intent
import androidx.appcompat.widget.Toolbar
import com.example.cardviewdemo.R
import com.example.cardviewdemo.ui.activity.SettingActivity


//Manage all toolbars
interface ToolBarManager {
    val toolbar: Toolbar

    //initialize toolbar in MainActivity
    fun initMainToolBar(){
        toolbar.setTitle("arXivPaperReader")
        toolbar.inflateMenu(R.menu.main)
        toolbar.setOnMenuItemClickListener {
            toolbar.context.startActivity(Intent(toolbar.context, SettingActivity::class.java))
            true
        }
        //jump to settings second choice
//        toolbar.setOnMenuItemClickListener(object :Toolbar.OnMenuItemClickListener{
//            override fun onMenuItemClick(item: MenuItem?): Boolean {
//                when(item?.itemId){
//                    R.id.setting->{
//  //test                      Toast.makeText(toolbar.context,"click setting button", Toast.LENGTH_LONG).show()
//                        //jump to setting fragment
//                        toolbar.context.startActivity(Intent(toolbar.context,SettingActivity::class.java))
//                    }
//                }
//                return true
//            }
//
//        })
    }
    //toolbar of Setting fragment
    fun initSettingToolbar(){
        toolbar.setTitle("Settings")
    }
}