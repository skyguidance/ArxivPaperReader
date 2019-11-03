package com.example.cardviewdemo.ui.fragment
import android.view.View
import android.widget.SearchView
import com.example.cardviewdemo.R
import com.example.cardviewdemo.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_search.*
import kotlinx.android.synthetic.main.fragment_search.view.*

class SearchFragment : BaseFragment() {
    override fun initView(): View? {
        var view =  View.inflate(context, R.layout.fragment_search, null)
        view.button_advanced_search.setOnClickListener {
            fragmentManager?.beginTransaction()?.addToBackStack(null)
                ?.replace(R.id.container,AdvancedSearchFragement())?.commit()
        }
        return view;
    }

    override fun initData() {
        search()
    }

    fun search(){
        search_view.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextChange(p0: String?): Boolean {
                return false

            }

            override fun onQueryTextSubmit(p0: String?): Boolean {
                println("DEBUG Search:"+p0)
                return false
            }
        })
    }


}