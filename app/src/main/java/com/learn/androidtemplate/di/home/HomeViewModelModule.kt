package com.learn.androidtemplate.di.home

import androidx.lifecycle.ViewModel
import com.learn.androidtemplate.di.ViewModelKey
import com.learn.androidtemplate.home.HomeActivityViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class HomeViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(HomeActivityViewModel::class)
    abstract fun bindsHomeActivityViewModel(homeActivityViewModel: HomeActivityViewModel): ViewModel
}
