package com.learn.androidtemplate.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import com.learn.androidtemplate.R
import com.learn.androidtemplate.db.Feed

class HomeAdapter:PagedListAdapter<Feed,HomeFeedViewHolder>(diffUtil){

    companion object{
        private val diffUtil = object : DiffUtil.ItemCallback<Feed>() {
            override fun areItemsTheSame(oldItem: Feed, newItem: Feed): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Feed, newItem: Feed): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeFeedViewHolder {
        val itemView =LayoutInflater.from(parent.context).inflate(R.layout.row_feed_layout,parent,false)
        return HomeFeedViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: HomeFeedViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}