package com.learn.androidtemplate.repository

import com.learn.androidtemplate.db.AppDatabase
import com.learn.androidtemplate.db.Feed
import com.learn.androidtemplate.network.home.HomeApi
import com.learn.androidtemplate.utils.toDb
import io.reactivex.Single
import javax.inject.Inject

class HomeRepository @Inject constructor(private val homeApi: HomeApi, private val db: AppDatabase) {

    fun fetchAllFeed(): Single<List<Feed>> {
        return homeApi.getImages(query = "yellow flower")
            .map { feedResponse -> feedResponse.hits.map { it.toDb() } }
            .doOnSuccess { db.feedDao().insertAll(it) }
    }

    fun getFeed() = db.feedDao().getAllFeed()
}