package com.learn.androidtemplate.repository

import androidx.paging.PagedList
import com.learn.androidtemplate.db.Feed
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class FeedBoundaryCallback(
    val fetchAndInsertFeed: (Int) -> Single<List<Feed>>
) : PagedList.BoundaryCallback<Feed>() {


    private var page: Int = 1
    private var isRequestRunning:Boolean = false

    override fun onZeroItemsLoaded() = loadMore()

    override fun onItemAtEndLoaded(itemAtEnd: Feed) = loadMore()

    private fun loadMore() {
        if(isRequestRunning) return
        isRequestRunning = true
        val disposable = fetchAndInsertFeed(page)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { ++page
                  isRequestRunning = false
                },
                { e ->
                    e.printStackTrace()
                    isRequestRunning = false
                }
            )
    }


}