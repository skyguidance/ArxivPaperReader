package com.example.cardviewdemo.widget

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import com.example.cardviewdemo.R

class HomeItemView: RelativeLayout {
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