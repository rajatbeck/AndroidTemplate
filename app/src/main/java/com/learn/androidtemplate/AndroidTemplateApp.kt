package com.learn.androidtemplate

import android.content.Context
import androidx.multidex.MultiDex
import com.facebook.stetho.Stetho
import com.learn.androidtemplate.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class AndroidTemplateApp:DaggerApplication(){


    override fun onCreate() {
        super.onCreate()
        if(BuildConfig.DEBUG)  Stetho.initializeWithDefaults(this)
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder()
            .application(this)
            .build()
    }

}