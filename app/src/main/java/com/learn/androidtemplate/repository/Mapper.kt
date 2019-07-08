package com.learn.androidtemplate.repository

import com.learn.androidtemplate.data.FeedDTO

fun FeedDTO.toDb() =
    Feed(
        id = this.id,
        user = this.user,
        imageUrl = this.imageURL?:"",
        webFormatURL = this.webFormatURL,
        userId = this.userId,
        userImageURL = this.userImageURL,
        imageWidth = this.imageWidth,
        imageHeight = this.imageHeight
    )
