package com.learn.androidtemplate.ui.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import androidx.paging.RxPagedListBuilder
import com.learn.androidtemplate.db.Feed
import com.learn.androidtemplate.repository.HomeRepository
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class HomeActivityViewModel @Inject constructor(val repository: HomeRepository) : ViewModel() {

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()
    var pagedFeedList = MutableLiveData<PagedList<Feed>>()

    fun fetchFeed() {
        compositeDisposable.add(
            repository.getPagedFeeds()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { list -> pagedFeedList.value = list },
                    { e -> e.printStackTrace()})
        )
    }


}