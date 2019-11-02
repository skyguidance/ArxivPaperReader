package com.example.cardviewdemo.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cardviewdemo.widget.HomeItemView

class HomeAdapter: RecyclerView.Adapter<HomeAdapter.HomeHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeHolder {
        return HomeHolder(HomeItemView(parent?.context))
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(holder: HomeHolder, position: Int) {

    }

    class HomeHolder(itemView:View):RecyclerView.ViewHolder(itemView){

    }
}