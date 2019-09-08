package com.learn.androidtemplate.repository

import androidx.lifecycle.MutableLiveData
import androidx.paging.PagedList
import androidx.paging.RxPagedListBuilder
import com.learn.androidtemplate.db.AppDatabase
import com.learn.androidtemplate.db.Feed
import com.learn.androidtemplate.network.home.HomeApi
import com.learn.androidtemplate.ui.NetworkState
import com.learn.androidtemplate.utils.toDb
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.Single
import javax.inject.Inject

class HomeRepository @Inject constructor(private val homeApi: HomeApi, private val db: AppDatabase) {

    companion object{
        private const val DEFAULT_NETWORK_PAGE_SIZE = 20
    }

    val networkState = MutableLiveData<NetworkState>()
    lateinit var feedBoundaryCallback: FeedBoundaryCallback

    private fun fetchAndInsertFeed(page: Int): Single<List<Feed>> {
        networkState.value = NetworkState.LOADING
        return homeApi.getImages(query = "yellow flower", page = page)
            .map { feedResponse -> feedResponse.hits.map { it.toDb() } }
            .doOnSuccess {
                db.feedDao().insertAll(it)
                networkState.postValue(NetworkState.LOADED)
            }
            .doOnError { e->
                networkState.postValue(NetworkState.error(e.message))
            }
    }


    fun getPagedFeeds(): Flowable<PagedList<Feed>> {
        feedBoundaryCallback = FeedBoundaryCallback(this::fetchAndInsertFeed)
        return RxPagedListBuilder(db.feedDao().getAllFeed(), DEFAULT_NETWORK_PAGE_SIZE)
            .setBoundaryCallback(feedBoundaryCallback)
            .buildFlowable(BackpressureStrategy.BUFFER)
    }
}