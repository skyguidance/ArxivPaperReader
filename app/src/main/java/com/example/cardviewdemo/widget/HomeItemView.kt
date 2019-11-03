package com.example.cardviewdemo.widget

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import com.example.cardviewdemo.R
import com.example.cardviewdemo.model.PaperBean
import kotlinx.android.synthetic.main.item_home.view.*

class HomeItemView: RelativeLayout {
    /*
    * Flash Each View with the PaperBean Data
    */
    fun setData(data: PaperBean) {
        article_title.setText(data.Title.replace("\n",""))
        article_authors.setText(data.Author)
        article_date_submit.setText("Submitted:"+data.UpdateTime)
        article_id.setText("ID:"+data.ArxivID)
        article_type.setText(data.Catorgary)
        article_abstract.setText(data.Abstract.replace("\n",""))
    }

    //new
    constructor(context: Context?) : super(context)
    //layout
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    //activity
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )
    //initialize fun
    init {
        View.inflate(context, R.layout.item_home,this)
    }

}