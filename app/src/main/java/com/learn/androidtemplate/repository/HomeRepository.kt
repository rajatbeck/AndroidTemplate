package com.learn.androidtemplate.repository

import androidx.paging.PagedList
import androidx.paging.RxPagedListBuilder
import androidx.paging.toLiveData
import com.learn.androidtemplate.db.AppDatabase
import com.learn.androidtemplate.db.Feed
import com.learn.androidtemplate.network.home.HomeApi
import com.learn.androidtemplate.utils.toDb
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class HomeRepository @Inject constructor(private val homeApi: HomeApi, private val db: AppDatabase) {

    private fun fetchAndInsertFeed(page: Int): Single<List<Feed>> {
        return homeApi.getImages(query = "yellow flower", page = page)
            .map { feedResponse -> feedResponse.hits.map { it.toDb() } }
            .doOnSuccess { db.feedDao().insertAll(it) }
    }


    fun getPagedFeeds(): Flowable<PagedList<Feed>> {
        return RxPagedListBuilder(db.feedDao().getAllFeed(), 10)
            .setBoundaryCallback(FeedBoundaryCallback(this::fetchAndInsertFeed))
            .buildFlowable(BackpressureStrategy.BUFFER)
    }
}