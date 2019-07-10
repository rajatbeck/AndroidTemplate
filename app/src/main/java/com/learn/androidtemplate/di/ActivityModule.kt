package com.learn.androidtemplate.di

import com.learn.androidtemplate.di.home.HomeModule
import com.learn.androidtemplate.di.home.HomeViewModelModule
import com.learn.androidtemplate.ui.home.HomeActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector(modules = [HomeViewModelModule::class,HomeModule::class])
    abstract fun providesHomeActivity(): HomeActivity
}