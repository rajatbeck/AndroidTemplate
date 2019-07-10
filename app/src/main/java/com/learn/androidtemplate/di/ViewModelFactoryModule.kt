package com.learn.androidtemplate.di

import androidx.lifecycle.ViewModelProvider
import com.learn.androidtemplate.utils.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule{

    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

}