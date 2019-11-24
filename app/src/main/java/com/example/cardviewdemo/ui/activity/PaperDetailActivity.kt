/**
 * Create by Qi,TianYi <qitianyi@gwmail.gwu.edu>
 * CSCI 6221 Course Project - Team 15 - Fall 2019. George Washington University.
 * Copyright 2019 - Present
 */
package com.example.cardviewdemo.ui.activity

import androidx.appcompat.widget.Toolbar
import com.example.cardviewdemo.R
import com.example.cardviewdemo.base.BaseActivity
import com.example.cardviewdemo.model.PaperBean
import com.example.cardviewdemo.util.ToolBarManager
import io.github.kbiakov.codeview.classifier.CodeProcessor
import kotlinx.android.synthetic.main.activity_paper_detail.*
import org.jetbrains.anko.find
import org.scilab.forge.jlatexmath.core.AjLatexMath
import com.example.cardviewdemo.api.mysql.mysql_add_history

/**
 * This is the Page Detail Activity.
 * This Activity displays paper detail info. like Author, Abstract(Rendered as LaTeX.)...
 */
class PaperDetailActivity : BaseActivity(), ToolBarManager {
    override val toolbar: Toolbar by lazy { find<Toolbar>(R.id.toolbar) }

    /**
     * Get the layout XML info.
     */
    override fun getLayoutId(): Int {
        return R.layout.activity_paper_detail
    }

    /**
     * Init Data for Activity.
     */
    override fun initData() {
        val paperDetailBean=intent.getParcelableExtra<PaperBean>("item")
        initPaperDetailToolbar(paperDetailBean, UID)
        AjLatexMath.init(this)
        CodeProcessor.init(this)
        setData(paperDetailBean)
        if (!UID.equals("") and !UID.equals("-1")) {
            Thread({
                mysql_add_history.mysql_add_history(UID.toInt(), paperDetailBean.Weblink)
            }).start()
        }
    }

    /**
     * Set Data by visiting the PaperBean Stucture.
     */
    fun setData(data: PaperBean) {
        article_title.setText(data.Title.replace("\n", ""))
        article_authors.setText(data.Author)
        article_date_submit.setText("Submitted:" + data.UpdateTime)
        article_id.setText("ID:" + data.ArxivID)
        article_type.setText(data.Catorgary)
        article_abstract.setText(data.Abstract.replace("\n", ""))
    }

}