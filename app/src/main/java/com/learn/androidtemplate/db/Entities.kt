package com.learn.androidtemplate.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "feed")
data class Feed(
    @PrimaryKey val id: Long,
    @ColumnInfo(name = "user_id") val userId: Long,
    @ColumnInfo(name = "user") val user: String,
    @ColumnInfo(name = "image_url") val imageUrl: String,
    @ColumnInfo(name = "webformatURL") val webFormatURL: String,
    @ColumnInfo(name = "user_image_url") val userImageURL: String,
    @ColumnInfo(name = "image_width") val imageWidth: Int,
    @ColumnInfo(name = "image_height") val imageHeight: Int,
    @ColumnInfo(name = "views") val views: Int,
    @ColumnInfo(name = "downloads") val downloads: Int,
    @ColumnInfo(name = "favorites") val favorites: Int,
    @ColumnInfo(name = "likes") val likes: Int,
    @ColumnInfo(name = "comments") val comments: Int
)