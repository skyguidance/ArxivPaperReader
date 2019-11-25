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
import com.example.cardviewdemo.adapter.FavoriteAdapter
import com.example.cardviewdemo.base.BaseFragment
import com.example.cardviewdemo.presenter.impl.FavoritePresenterImpl
import com.example.cardviewdemo.ui.activity.PaperDetailActivity
import com.example.cardviewdemo.view.FavoriteView
import kotlinx.android.synthetic.main.fragment_favorite.*
import org.jetbrains.anko.support.v4.startActivity

/**
 * This is the Favorite fragment.
 * Users' favorite lists is presented in this fragment.
 */
class FavoriteFragement : BaseFragment(),FavoriteView {
    /**
     * Create a Favorite fragment.
     */
    fun newInstance(): FavoriteFragement {
        return FavoriteFragement()
    }


    override fun loadSuccess(
        cleanPrevious: Int,
        romeResult: MutableList<List<MutableList<String>>>
    ) {
        rl_favorite_list?.isRefreshing = false
        adapter.updateList(cleanPrevious, romeResult)
    }


    override fun initView(): View? {
        getThisUser()
        var bundle = getArguments()
        return View.inflate(context, R.layout.fragment_favorite, null)
    }


    val adapter by lazy { FavoriteAdapter() }
    val presenter by lazy { FavoritePresenterImpl(this) }

    override fun initListener() {
        rv_favorite_list.layoutManager = LinearLayoutManager(context)
        rv_favorite_list.adapter = adapter
        rl_favorite_list.setColorSchemeColors(Color.RED)
        rl_favorOnScrollListenerite_list.setOnRefreshListener {
            //Listen on refresh
            presenter.loadDatas(UID.toInt())
        }
        // listen to the swap
        rv_favorite_list.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(rv_favorite_list: RecyclerView, dx: Int, dy: Int) {
            }
            override fun onScrollStateChanged(rv_favorite_list: RecyclerView, newState: Int) {
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    val layoutManager = rv_favorite_list.layoutManager
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
