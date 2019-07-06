package com.learn.androidtemplate.data

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ImageDTO(
    @Json(name ="id") val id: Long,
    @Json(name ="user_id") val user_id: Long,
    @Json(name ="user") val user: String,
    @Json(name ="userImageURL") val userImageURL: String,
    @Json(name ="imageWidth") val imageWidth: Int,
    @Json(name ="imageHeight") val imageHeight: Int

)

data class ImageResponse(
    @Json(name ="hits") val hits:Array<ImageDTO>
)