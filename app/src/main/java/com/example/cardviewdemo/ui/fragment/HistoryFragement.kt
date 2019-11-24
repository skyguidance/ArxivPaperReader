/**
 * Create by Hang,Wu <hwu91@gwu.edu>
 * CSCI 6221 Course Project - Team 15 - Fall 2019. George Washington University.
 * Copyright 2019 - Present
 */
import android.graphics.Color
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cardviewdemo.R
import com.example.cardviewdemo.adapter.HistoryAdapter
import com.example.cardviewdemo.base.BaseFragment
import com.example.cardviewdemo.presenter.impl.HistoryPresenterImpl
import com.example.cardviewdemo.ui.activity.PaperDetailActivity
import com.example.cardviewdemo.view.HistoryView
import kotlinx.android.synthetic.main.fragment_history.*
import org.jetbrains.anko.support.v4.startActivity

class HistoryFragement : BaseFragment(),HistoryView {
    fun newInstance(): HistoryFragement {
        return HistoryFragement()
    }


    override fun loadSuccess(
        cleanPrevious: Int,
        romeResult: MutableList<List<MutableList<String>>>
    ) {
        rl_history_list?.isRefreshing = false
        adapter.updateList(cleanPrevious, romeResult)
    }


    override fun initView(): View? {
        getThisUser()
        var bundle = getArguments()
        return View.inflate(context, R.layout.fragment_history, null)
    }


    val adapter by lazy { HistoryAdapter() }
    val presenter by lazy { HistoryPresenterImpl(this) }

    override fun initListener() {
        rv_history_list.layoutManager = LinearLayoutManager(context)
        rv_history_list.adapter = adapter
        rl_history_list.setColorSchemeColors(Color.RED)
        rl_history_list.setOnRefreshListener {
            //Listen on refresh
            presenter.loadDatas(UID.toInt())
        }
        // listen to the swap
        rv_history_list.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(rv_history_list: RecyclerView, dx: Int, dy: Int) {

            }

            override fun onScrollStateChanged(rv_history_list: RecyclerView, newState: Int) {
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    val layoutManager = rv_history_list.layoutManager
                    if (layoutManager is LinearLayoutManager) {
                        val manager: LinearLayoutManager = layoutManager
                        val lastPosition = manager.findLastVisibleItemPosition()
                        if (lastPosition == adapter.itemCount - 1) {
                            // is the last one
                            presenter.loadMore(adapter.itemCount - 1, UID.toInt())
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
        presenter.loadDatas(UID.toInt())
    }

}
