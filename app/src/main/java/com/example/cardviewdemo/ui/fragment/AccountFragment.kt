package com.example.cardviewdemo.ui.fragment

import CreditFragement
import FavoriteFragement
import HistoryFragement
import SettingsFragement
import android.view.View
import com.example.cardviewdemo.R
import com.example.cardviewdemo.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_account.view.*
import kotlinx.android.synthetic.main.fragment_account.view.btn_credit

class AccountFragment : BaseFragment(){
    fun newInstance(): AccountFragment {
        return AccountFragment()
    }

    override fun initView(): View? {
        if ((getThisUser().equals("")==false) and (getThisUser().equals("-1")==false)){
            fragmentManager?.beginTransaction()?.addToBackStack(null)
                ?.replace(R.id.container,AccountFragmentLogin())?.commit()
        }

        var view = View.inflate(context, R.layout.fragment_account, null)

        view.btn_login.setOnClickListener {
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