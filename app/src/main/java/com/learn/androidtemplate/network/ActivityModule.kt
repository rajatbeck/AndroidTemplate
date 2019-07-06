package com.learn.androidtemplate.network

import com.learn.androidtemplate.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule{

    @ContributesAndroidInjector(modules = [])
    abstract fun providesMainActivity():MainActivity
}