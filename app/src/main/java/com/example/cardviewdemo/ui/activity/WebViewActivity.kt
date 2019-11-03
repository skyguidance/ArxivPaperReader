package com.example.cardviewdemo.ui.activity

import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.widget.Toolbar
import com.example.cardviewdemo.R
import com.example.cardviewdemo.base.BaseActivity
import com.example.cardviewdemo.model.PaperBean
import com.example.cardviewdemo.util.ToolBarManager
import kotlinx.android.synthetic.main.webview.*
import org.jetbrains.anko.find

class WebViewActivity: BaseActivity(), ToolBarManager {
    override val toolbar: Toolbar by lazy { find<Toolbar>(R.id.toolbar) }
    override fun getLayoutId(): Int {
        return R.layout.webview
    }

    override fun initData() {
        val intent = getIntent()
        val data = intent.getParcelableExtra<PaperBean>("item")
        var url = "http://csci6221.skyguidance.xyz/papers/"+data.ArxivID
        initPDFToolbar()
        webviewbrowser.getSettings().setJavaScriptEnabled(true)
        webviewbrowser.getSettings().setDomStorageEnabled(true)
        webviewbrowser.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                view?.loadUrl(url)
                return true
            }
        }
        webviewbrowser.loadUrl(url)
    }
}