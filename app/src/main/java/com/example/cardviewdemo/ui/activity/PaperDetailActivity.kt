package com.example.cardviewdemo.ui.activity

import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import com.example.cardviewdemo.R
import com.example.cardviewdemo.base.BaseActivity
import com.example.cardviewdemo.model.PaperBean
import com.example.cardviewdemo.util.ToolBarManager
import kotlinx.android.synthetic.main.activity_paper_detail.*
import kotlinx.android.synthetic.main.item_home.view.*
import org.jetbrains.anko.find

class PaperDetailActivity : BaseActivity(),ToolBarManager {
    override val toolbar: Toolbar by lazy { find<Toolbar>(R.id.toolbar) }
    override fun getLayoutId(): Int {
        return R.layout.activity_paper_detail
    }


    override fun initData() {
        val paperDetailBean = intent.getParcelableExtra<PaperBean>("item")
        initPaperDetailToolbar(paperDetailBean)
        setData(paperDetailBean)
        //println("itemBean=$paperDetailBean")
    }

    fun setData(data:PaperBean){
        article_title.setText(data.Title.replace("\n",""))
        article_authors.setText(data.Author)
        article_date_submit.setText("Submitted:"+data.UpdateTime)
        article_id.setText("ID:"+data.ArxivID)
        article_type.setText(data.Catorgary)
        article_abstract.setText(data.Abstract.replace("\n",""))
    }



}