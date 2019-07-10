package com.learn.androidtemplate.network.home

import com.learn.androidtemplate.BuildConfig
import com.learn.androidtemplate.data.ImageResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface HomeApi {
    @GET("?")
    fun getImages(@Query("key") apiKey: String = BuildConfig.API_KEY,
                  @Query("q") query: String,
                  @Query("image_type") imageType:String="photo",
                  @Query("page") page:Int=1,
                  @Query("per_page") perPage:Int=20
    ): Single<ImageResponse>
}