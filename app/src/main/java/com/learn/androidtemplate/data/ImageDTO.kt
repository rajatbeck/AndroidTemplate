package com.learn.androidtemplate.data

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class FeedDTO(
    @Json(name = "id") val id: Long,
    @Json(name = "user_id") val userId: Long,
    @Json(name = "user") val user: String,
    @Json(name = "imageURL") val imageURL: String?,
    @Json(name = "webformatURL") val webFormatURL: String,
    @Json(name = "userImageURL") val userImageURL: String,
    @Json(name = "imageWidth") val imageWidth: Int,
    @Json(name = "imageHeight") val imageHeight: Int,
    @Json(name = "views") val views: Int,
    @Json(name = "downloads") val downloads: Int,
    @Json(name = "favorites") val favorites: Int,
    @Json(name = "likes") val likes: Int,
    @Json(name = "comments") val comments: Int
    )

@JsonClass(generateAdapter = true)
data class ImageResponse(
    @Json(name = "hits") val hits: Array<FeedDTO>
)