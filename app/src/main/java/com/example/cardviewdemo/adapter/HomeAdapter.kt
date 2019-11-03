package com.example.cardviewdemo.adapter

import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.cardviewdemo.model.PaperBean
import com.example.cardviewdemo.widget.HomeItemView
import com.example.cardviewdemo.widget.LoadMoreView

class HomeAdapter : RecyclerView.Adapter<HomeAdapter.HomeHolder>() {
    private var list = ArrayList<PaperBean>()

    fun updateList(cleanPrevious:Int,romeResult: MutableList<List<MutableList<String>>>) {
        // if cleanPrevious is set to 1,the previous list will be cleaned.
        if (cleanPrevious == 1){
            this.list.clear()
        }
        for (paper in romeResult) {
            var authorString = String()
            for (author in paper.get(2)) {
                authorString = authorString + author
            }
            var arxivID = paper.get(0).get(0).replace("http://arxiv.org/abs/", "")
            var item = PaperBean(
                Weblink = paper.get(0).get(0),
                Title = paper.get(1).get(0),
                Author = authorString,
                Abstract = paper.get(3).get(0),
                Catorgary = paper.get(4).get(0),
                UpdateTime = paper.get(5).get(0),
                PDFLink = paper.get(8).get(0),
                ArxivID = arxivID
            )
            this.list.add(item)
        }
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int): Int {
        if(position == list.size){
            // is the last one
            return 1
        }else{
            return 0
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeHolder {
        if(viewType  == 1){
            // is the last card. refreshing
            return HomeHolder(LoadMoreView(parent?.context))
        }
        else{
            // is the article card
            return HomeHolder(HomeItemView(parent?.context))
        }
    }

    override fun getItemCount(): Int {
        return list.size + 1
    }

    override fun onBindViewHolder(holder: HomeHolder, position: Int) {
        if (position == list.size){
            return
        }
        val data = list.get(position)
        val itemView = holder?.itemView as HomeItemView
        itemView.setData(data)
    }

    class HomeHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}