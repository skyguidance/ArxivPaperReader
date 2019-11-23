/**
 * Create by Qi,TianYi <qitianyi@gwmail.gwu.edu>
 * CSCI 6221 Course Project - Team 15 - Fall 2019. George Washington University.
 * Copyright 2019 - Present
 */
package com.example.cardviewdemo.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cardviewdemo.model.PaperBean
import com.example.cardviewdemo.widget.HomeItemView
import com.example.cardviewdemo.widget.LoadMoreView

/**
 * Added Page Browse Adapter.
 * This Adapter drives the Page Browse Card View.
 */
class PageBrowseAdapter : RecyclerView.Adapter<PageBrowseAdapter.PageBrowseHolder>() {
    private var list=ArrayList<PaperBean>()

    /**
     * Parcel the API back info to a PaperBean.
     */
    fun updateList(cleanPrevious: Int, romeResult: MutableList<List<MutableList<String>>>) {
        /**
         * if cleanPrevious is set to 1,the previous list will be cleaned.
         */
        if (cleanPrevious == 1) {
            this.list.clear()
        }
        for (paper in romeResult) {
            var authorString=String()
            for (author in paper.get(2)) {
                authorString=authorString + author
            }
            var arxivID=paper.get(0).get(0).replace("http://arxiv.org/abs/", "")
            var item=PaperBean(
                Weblink=paper.get(0).get(0),
                Title=paper.get(1).get(0),
                Author=authorString,
                Abstract=paper.get(3).get(0),
                Catorgary=paper.get(4).get(0),
                UpdateTime=paper.get(5).get(0),
                PDFLink=paper.get(8).get(0),
                ArxivID=arxivID
            )
            this.list.add(item)
        }
        notifyDataSetChanged()
    }

    /**
     * Check if the item is the last one.
     */
    override fun getItemViewType(position: Int): Int {
        if (position == list.size) {
            /**
             * is the last one
             */
            return 1
        } else {
            return 0
        }
    }

    /**
     * Check if the this is the last card view visiable on the GUI.
     */
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PageBrowseAdapter.PageBrowseHolder {
        if (viewType == 1) {
            /**
             * is the last card. refreshing
             */
            return PageBrowseAdapter.PageBrowseHolder(LoadMoreView(parent?.context))
        } else {
            /**
             * is the article card
             */
            return PageBrowseAdapter.PageBrowseHolder(HomeItemView(parent?.context))
        }
    }

    /**
     * Get how many papers have we fetched.
     */
    override fun getItemCount(): Int {
        return list.size + 1
    }

    /**
     * Bind On click lister for card view item. Jump to  HomeItemView.
     */
    override fun onBindViewHolder(holder: PageBrowseAdapter.PageBrowseHolder, position: Int) {
        if (position == list.size) {
            return
        }
        val data=list.get(position)
        val itemView=holder?.itemView as HomeItemView
        itemView.setData(data)
        itemView.setOnClickListener {
            listener?.let {
                it(data)
            }
        }
    }

    var listener: ((paperBean: PaperBean) -> Unit)?=null

    /**
     * Set the paper Bean Click Listener.
     */
    fun setMyListener(listener: (paperBean: PaperBean) -> Unit) {
        this.listener=listener
    }

    /**
     * This is the Page Browser Holder.
     */
    class PageBrowseHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}