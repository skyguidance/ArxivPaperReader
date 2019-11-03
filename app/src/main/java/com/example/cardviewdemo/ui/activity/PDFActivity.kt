package com.example.cardviewdemo.ui.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.LinearLayout
import android.widget.Toolbar


import com.example.cardviewdemo.R
import com.example.cardviewdemo.base.BaseActivity
import com.example.cardviewdemo.model.PaperBean
import com.example.cardviewdemo.util.ToolBarManager

import es.voghdev.pdfviewpager.library.RemotePDFViewPager
import es.voghdev.pdfviewpager.library.adapter.PDFPagerAdapter
import es.voghdev.pdfviewpager.library.remote.DownloadFile
import es.voghdev.pdfviewpager.library.util.FileUtil
import kotlinx.android.synthetic.main.webview.*
import org.jetbrains.anko.find

class PDFActivity : BaseActivity() {
    override fun getLayoutId(): Int {
        return R.layout.webview
    }

    override fun initData() {
        val intent = getIntent()
        val data = intent.getParcelableExtra<PaperBean>("item")
        var url = data.PDFLink.toString()
        webviewbrowser.getSettings().setJavaScriptEnabled(true)
        webviewbrowser.getSettings().setDomStorageEnabled(true)
//        webviewbrowser.webViewClient = object : WebViewClient() {
//            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
//                view?.loadUrl(url)
//                return true
//            }
//        }
        webviewbrowser.loadUrl(url)
    }
}

