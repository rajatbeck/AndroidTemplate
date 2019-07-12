package com.learn.androidtemplate.utils

import com.learn.androidtemplate.data.FeedDTO
import com.learn.androidtemplate.db.Feed

fun FeedDTO.toDb() =
    Feed(
        id = this.id,
        user = this.user,
        imageUrl = this.imageURL ?: "",
        webFormatURL = this.webFormatURL,
        userId = this.userId,
        userImageURL = this.userImageURL,
        imageWidth = this.imageWidth,
        imageHeight = this.imageHeight,
        views = this.views,
        downloads = this.downloads,
        favorites = this.favorites,
        likes = this.likes,
        comments = this.comments
    )
