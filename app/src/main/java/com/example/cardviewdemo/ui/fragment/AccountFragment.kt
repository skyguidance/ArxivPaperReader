package com.example.cardviewdemo.ui.fragment

import CreditFragement
import FavoriteFragement
import HistoryFragement
import SettingsFragement
import android.view.View
import com.example.cardviewdemo.R
import com.example.cardviewdemo.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_account.view.*

class AccountFragment : BaseFragment(){
    fun newInstance(): AccountFragment {
        return AccountFragment()
    }

    override fun initView(): View? {

        var view = View.inflate(context, R.layout.fragment_account, null)

        view.btn_favorites.setOnClickListener {
            fragmentManager?.beginTransaction()?.addToBackStack(null)
                ?.replace(R.id.container,FavoriteFragement())?.commit()
        }
        view.btn_history.setOnClickListener {
            fragmentManager?.beginTransaction()?.addToBackStack(null)
                ?.replace(R.id.container,HistoryFragement())?.commit()
        }
        view.btn_settings.setOnClickListener {
            if (isRegistered()) {
                fragmentManager?.beginTransaction()?.addToBackStack(null)
                    ?.replace(R.id.container,LoginFragment())?.commit()
            }else {
                fragmentManager?.beginTransaction()?.addToBackStack(null)
                    ?.replace(R.id.container,SettingsFragement())?.commit()
            }
        }
        view.btn_credit.setOnClickListener {
            fragmentManager?.beginTransaction()?.addToBackStack(null)
                ?.replace(R.id.container,CreditFragement())?.commit()
        }
        return view;
    }

}