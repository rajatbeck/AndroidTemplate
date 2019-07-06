package com.learn.androidtemplate.di

import com.learn.androidtemplate.HomeActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule{

    @ContributesAndroidInjector(modules = [])
    abstract fun providesHomeActivity():HomeActivity
}