package com.learn.androidtemplate.home

import android.util.Log
import androidx.lifecycle.ViewModel
import com.learn.androidtemplate.repository.HomeRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.reactivestreams.Publisher
import javax.inject.Inject

class HomeActivityViewModel @Inject constructor(val repository: HomeRepository):ViewModel(){


    fun check(){
        repository.fetchAllFeed()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { t1, t2->
                Log.d("******",t1.toString())
            }
    }

}