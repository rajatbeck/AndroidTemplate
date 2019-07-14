package com.learn.androidtemplate.ui.home

import android.graphics.drawable.Drawable
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.learn.androidtemplate.AndroidTempGlideExtension.Companion.feedPhoto
import com.learn.androidtemplate.GlideApp
import com.learn.androidtemplate.GlideRequests
import com.learn.androidtemplate.db.Feed
import kotlinx.android.synthetic.main.row_feed_layout.view.*


class HomeFeedViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(feed: Feed?) = run {
        itemView.image_loader.playAnimation()

        GlideApp.with(itemView.context)
            .load(feed?.webFormatURL)
            .listener(object : RequestListener<Drawable> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: com.bumptech.glide.request.target.Target<Drawable>?,
                    isFirstResource: Boolean
                ): Boolean {
                    itemView.image_loader.progress = 0F
                    itemView.image_loader.pauseAnimation()
                    return false
                }

                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any?,
                    target: com.bumptech.glide.request.target.Target<Drawable>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
                    itemView.image_loader.progress = 0F
                    itemView.image_loader.pauseAnimation()
                    return false
                }
            })
            .feedPhoto()
            .into(itemView.ivFeed)

        GlideApp.with(itemView.context)
            .load(feed?.userImageURL)
            .profilePhoto()
            .into(itemView.profilePic)

        itemView.tvUserName.text = feed?.user
        itemView.likeCount.text = "${feed?.likes}"
    }

}