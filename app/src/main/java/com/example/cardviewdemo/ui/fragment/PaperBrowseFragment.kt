package com.example.cardviewdemo.ui.fragment

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cardviewdemo.R
import com.example.cardviewdemo.adapter.PageBrowseAdapter
import com.example.cardviewdemo.base.BaseFragment
import com.example.cardviewdemo.presenter.impl.PageBrowsePresenterImpl
import com.example.cardviewdemo.ui.activity.PaperDetailActivity
import com.example.cardviewdemo.view.PageBrowserView
import kotlinx.android.synthetic.main.fragment_paper_browse.*
import org.jetbrains.anko.support.v4.startActivity

class PaperBrowseFragment : BaseFragment(), PageBrowserView {
    var SearchWord: String = ""
    var SearchCatorgary: String = ""
    override fun loadSuccess(
        cleanPrevious: Int,
        romeResult: MutableList<List<MutableList<String>>>
    ) {
        //TODO: BUG: If not refreshed homeview, click accountview may break down
        refreshLayout?.isRefreshing = false
        adapter.updateList(cleanPrevious, romeResult)
    }


    override fun initView(): View? {
        getThisUser()
        var bundle = getArguments()
        if (bundle != null) {
            SearchWord = bundle.getString("SearchWord")
            SearchCatorgary = bundle.getString("Category")
            println("SearchWord:"+SearchWord)
            println("SearchCatorgary:"+SearchCatorgary)
        }
        return View.inflate(context, R.layout.fragment_paper_browse, null)
    }


    val adapter by lazy { PageBrowseAdapter() }
    val presenter by lazy { PageBrowsePresenterImpl(this) }

    override fun initListener() {
        //initialize recycleView
        recycleView.layoutManager = LinearLayoutManager(context)
        //adapt
        recycleView.adapter = adapter
        //initialize swipeRefresh
        refreshLayout.setColorSchemeColors(Color.RED)
        refreshLayout.setOnRefreshListener {
            //Listen on refresh
            presenter.loadDatas(SearchCatorgary, SearchWord)
        }
        // listen to the swap
        recycleView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {

            }

            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    val layoutManager = recyclerView.layoutManager
                    if (layoutManager is LinearLayoutManager) {
                        val manager: LinearLayoutManager = layoutManager
                        val lastPosition = manager.findLastVisibleItemPosition()
                        if (lastPosition == adapter.itemCount - 1) {
                            // is the last one
                            presenter.loadMore(adapter.itemCount - 1, SearchCatorgary, SearchWord)
                        }
                    }
                }
            }

        })

        adapter.setMyListener {
            startActivity<PaperDetailActivity>("item" to it)
        }
    }


    override fun initData() {
        presenter.loadDatas(SearchCatorgary, SearchWord)
    }

}