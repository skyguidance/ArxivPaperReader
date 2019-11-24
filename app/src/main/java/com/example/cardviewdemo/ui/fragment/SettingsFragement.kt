/**
 * Create by Liu,GaoZhi <chrysalisliu@gwu.edu>
 * CSCI 6221 Course Project - Team 15 - Fall 2019. George Washington University.
 * Copyright 2019 - Present
 */
import android.view.View
import com.example.cardviewdemo.R
import com.example.cardviewdemo.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_settings.view.*

/**
 * This is the Settings Fragment. (Old.)
 */
class SettingsFragement : BaseFragment() {
    /**
     * Create User Settings Fragment.
     */
    fun newInstance(): SettingsFragement {
        return SettingsFragement()
    }

    /**
     * Init View.
     */
    override fun initView(): View? {
        var view=View.inflate(context, R.layout.fragment_settings, null)
        return view;
    }


}
