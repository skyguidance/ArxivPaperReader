package com.example.cardviewdemo.util

import android.content.Intent
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import com.example.cardviewdemo.R
import com.example.cardviewdemo.api.mysql.mysql_add_favorite
import com.example.cardviewdemo.model.PaperBean
import com.example.cardviewdemo.ui.activity.PDFActivity
import com.example.cardviewdemo.ui.activity.SettingActivity
import com.example.cardviewdemo.ui.activity.WebViewActivity



//Manage all toolbars
interface ToolBarManager {
    val toolbar: Toolbar

    //initialize toolbar in MainActivity
    fun initMainToolBar() {
        toolbar.setTitle("arXivPaperReader")
        toolbar.inflateMenu(R.menu.main)
        toolbar.setOnMenuItemClickListener {
            gotoSettings()
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
    fun initSettingToolbar() {
        toolbar.setTitle("Settings")
    }

    fun initPDFToolbar() {
        toolbar.setTitle("arXivPaperReader")
    }

    //toolbar of Paper Detail Activity
    fun initPaperDetailToolbar(paperDetailBean: PaperBean,UID:String) {
        println("DEBUG:initPaperDetailToolbar:getUID:"+UID)
        toolbar.setTitle("arXivPaperReader")
        toolbar.inflateMenu(R.menu.paper_detail)
        toolbar.setOnMenuItemClickListener(object : Toolbar.OnMenuItemClickListener {
            override fun onMenuItemClick(item: MenuItem?): Boolean {
                when (item?.itemId) {
                    R.id.favourite -> {
                        addFavourite(paperDetailBean,UID)
                        return true
                    }
//                    R.id.favourited -> {
//                        //delete favourite
//                        return true
//                    }
                    R.id.pdf -> {
                        viewAsPDF(paperDetailBean)
                        return true
                    }
                    R.id.renderLatex -> {
                        viewAsLaTeX(paperDetailBean)
                        return true
                    }
                    R.id.setting -> {
                        gotoSettings()
                        return true
                    }
                }
                return true
            }
        })
    }

    fun gotoSettings(): Boolean {
        toolbar.context.startActivity(Intent(toolbar.context, SettingActivity::class.java))
        return true
    }

    fun addFavourite(paperDetailBean: PaperBean,UID: String) {
        val i = 1
        println("DEBUG:ADD_FAV"+i)
        Thread({
            mysql_add_favorite.mysql_add_favorite(UID.toInt(),paperDetailBean.Weblink)
        }).start()

    }

    fun viewAsPDF(paperDetailBean: PaperBean) {
        var intent = Intent()
        intent.putExtra("item", paperDetailBean)
        intent.setClass(toolbar.context, PDFActivity::class.java)
        toolbar.context.startActivity(intent)
    }

    fun viewAsLaTeX(paperDetailBean: PaperBean) {
        var intent = Intent()
        intent.putExtra("item", paperDetailBean)
        intent.setClass(toolbar.context, WebViewActivity::class.java)
        toolbar.context.startActivity(intent)
    }




}