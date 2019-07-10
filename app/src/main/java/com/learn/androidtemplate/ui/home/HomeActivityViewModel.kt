package com.learn.androidtemplate.ui.home

import android.util.Log
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

    fun check():Flowable<PagedList<Feed>> {
       return RxPagedListBuilder(repository.getAllFeed(),20)
            .buildFlowable(BackpressureStrategy.BUFFER)
    }

}