/**
 * Create by Wu,Hang <hwu91@gwmail.gwu.edu>
 * CSCI 6221 Course Project - Team 15 - Fall 2019. George Washington University.
 * Copyright 2019 - Present
 */
import android.view.View
import com.example.cardviewdemo.base.BaseFragment
import mehdi.sakout.aboutpage.AboutPage
import mehdi.sakout.aboutpage.Element

/**
 * This is the about fragment.
 * Credit info is presented in this fragment.
 */
class CreditFragement : BaseFragment() {
    /**
     * Create a Credit fragment.
     */
    fun newInstance(): CreditFragement {
        return CreditFragement()
    }

    /**
     * Init View.
     */
    override fun initView(): View? {
        var string: String=context?.getResources()!!.getString(
            com.example.cardviewdemo.R.string.credit_text
        );
        var view=AboutPage(context)
            .isRTL(true)
            .setDescription(string)
            .addItem(Element().setTitle("Version 1.0"))
            .create()
        return view;
    }


}
