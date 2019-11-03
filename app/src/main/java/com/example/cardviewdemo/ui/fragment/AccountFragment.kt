package com.example.cardviewdemo.ui.fragment

import android.graphics.Color
import android.view.Gravity
import android.view.View
import android.widget.TextView
import com.example.cardviewdemo.base.BaseFragment

class AccountFragment : BaseFragment(){
    fun newInstance(): AccountFragment {
        return AccountFragment()
    }

    fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_account, container, false)

    }



    override fun initView(): View? {

        val tv = TextView(context)
        tv.gravity = Gravity.CENTER
        tv.setTextColor(Color.RED)
        tv.text = javaClass.simpleName

        val tv2 = TextView(context)

        return tv
    }

}