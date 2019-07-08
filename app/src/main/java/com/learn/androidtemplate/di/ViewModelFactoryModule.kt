package com.learn.androidtemplate.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.learn.androidtemplate.home.HomeActivityViewModel
import com.learn.androidtemplate.utils.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelFactoryModule{

    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

}