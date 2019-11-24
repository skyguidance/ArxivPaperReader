/**
 * Create by Qi,TianYi <qitianyi@gwmail.gwu.edu>
 * CSCI 6221 Course Project - Team 15 - Fall 2019. George Washington University.
 * Copyright 2019 - Present
 */
package com.example.cardviewdemo.widget

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import com.example.cardviewdemo.R
import com.example.cardviewdemo.model.PaperBean
import kotlinx.android.synthetic.main.item_home.view.*

/**
 * Set Per CardView with PaperDetail in the PaperBean Stucture.
 */
class HomeItemView : RelativeLayout {
    /**
     * Flash Each View with the PaperBean Data
     */
    fun setData(data: PaperBean) {
        article_title.setText(data.Title.replace("\n", ""))
        article_authors.setText(data.Author)
        article_date_submit.setText("Submitted:" + data.UpdateTime)
        article_id.setText("ID:" + data.ArxivID)
        article_type.setText(data.Catorgary)
        article_abstract.setText(data.Abstract.replace("\n", ""))
    }

    /**
     * New constructor.
     */
    constructor(context: Context?) : super(context)

    /**
     * Layout constructor.
     */
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)

    /**
     * Activity constructor.
     */
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    /**
     * Initialize view.
     */
    init {
        View.inflate(context, R.layout.item_home, this)
    }

}