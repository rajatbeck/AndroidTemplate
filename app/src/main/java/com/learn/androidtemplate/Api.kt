package com.learn.androidtemplate

import com.learn.androidtemplate.data.ImageResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET
    fun getImages(@Query("key") apiKey: String = BuildConfig.API_KEY, @Query("q") query: String): Single<ImageResponse>
}