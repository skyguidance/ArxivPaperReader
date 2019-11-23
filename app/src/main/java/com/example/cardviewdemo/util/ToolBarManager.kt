/**
 * Create by Liu,GaoZhi <chrysalisliu@gwu.edu>
 * CSCI 6221 Course Project - Team 15 - Fall 2019. George Washington University.
 * Copyright 2019 - Present
 */
package com.example.cardviewdemo.util

import android.content.Intent
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import com.example.cardviewdemo.R
import com.example.cardviewdemo.api.mysql.mysql_add_favorite
import com.example.cardviewdemo.model.PaperBean
import com.example.cardviewdemo.ui.activity.*


/**
 * The Top Toolbar (ActionBar) Interface for the Project
 */
interface ToolBarManager {
    val toolbar: Toolbar

    /**
     * initialize toolbar in MainActivity(The 3 Basic Views,Search,Browse,Account)
     */
    fun initMainToolBar() {
        toolbar.setTitle("arXivPaperReader")
        toolbar.inflateMenu(R.menu.main)
        toolbar.setOnMenuItemClickListener {
            gotoSettings()
        }
    }

    /**
     * initialize toolbar in Setting Fragment
     */
    fun initSettingToolbar() {
        toolbar.setTitle("Settings")
    }

    /**
     * initialize toolbar for the PDF Download View
     */
    fun initPDFToolbar() {
        toolbar.setTitle("arXivPaperReader")
    }

    /**
     * initialize toolbar in PageDetailView.
     */
    fun initPaperDetailToolbar(paperDetailBean: PaperBean, UID: String) {
        toolbar.setTitle("arXivPaperReader")
        toolbar.inflateMenu(R.menu.paper_detail)
        toolbar.setOnMenuItemClickListener(object : Toolbar.OnMenuItemClickListener {
            override fun onMenuItemClick(item: MenuItem?): Boolean {
                when (item?.itemId) {
                    // Jump to Favourite actions
                    R.id.favourite -> {
                        addFavourite(paperDetailBean, UID)
                        return true
                    }
                    // Jump to download PDF
                    R.id.pdf -> {
                        viewAsPDF(paperDetailBean)
                        return true
                    }
                    // Jump to Render Latex
                    R.id.renderLatex -> {
                        viewAsLaTeX(paperDetailBean)
                        return true
                    }
                    // Jump to Settings fragment
                    R.id.setting -> {
                        gotoSettings()
                        return true
                    }
                }
                return true
            }
        })
    }

    /**
     * Jump to Settings Fragment
     */
    fun gotoSettings(): Boolean {
        toolbar.context.startActivity(Intent(toolbar.context, SettingActivity::class.java))
        return true
    }

    /**
     * Add Favourite.
     * Add this paper to the user favourite list.
     */
    fun addFavourite(paperDetailBean: PaperBean, UID: String) {
        val i=1
        if (!UID.equals("") and !UID.equals("-1")) {
            Thread({
                mysql_add_favorite.mysql_add_favorite(UID.toInt(), paperDetailBean.Weblink)
            }).start()
        }
    }

    /**
     * Jump to View PDF Fragment.
     */
    fun viewAsPDF(paperDetailBean: PaperBean) {
        var intent=Intent()
        intent.putExtra("item", paperDetailBean)
        intent.setClass(toolbar.context, PDFActivity::class.java)
        toolbar.context.startActivity(intent)
    }

    /**
     * Jump to Render LaTeX Fragment.
     */
    fun viewAsLaTeX(paperDetailBean: PaperBean) {
        var intent=Intent()
        intent.putExtra("item", paperDetailBean)
        intent.setClass(toolbar.context, WebViewActivity::class.java)
        toolbar.context.startActivity(intent)
    }


}