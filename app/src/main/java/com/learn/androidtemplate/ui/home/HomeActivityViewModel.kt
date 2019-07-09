package com.learn.androidtemplate.ui.home

import android.util.Log
import androidx.lifecycle.ViewModel
import com.learn.androidtemplate.repository.HomeRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class HomeActivityViewModel @Inject constructor(val repository: HomeRepository) : ViewModel() {

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    fun check() {
        compositeDisposable.add(repository.fetchAllFeed()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { listFeed ->
                    Log.d("******", listFeed.toString())
                },
                { e -> e.printStackTrace() }
            ))
    }

}