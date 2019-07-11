package com.learn.androidtemplate.ui.home

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.learn.androidtemplate.db.Feed
import kotlinx.android.synthetic.main.row_feed_layout.view.*

class HomeFeedViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

    fun bind(feed: Feed?) = run {
        Glide.with(itemView.context)
//            .setDefaultRequestOptions()
            .load(feed?.webFormatURL)
            .into(itemView.ivFeed)
    }

}