package com.learn.androidtemplate.di

import android.app.Application
import com.learn.androidtemplate.AndroidTemplateApp
import com.learn.androidtemplate.network.NetworkModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        NetworkModule::class,
        AppModule::class,
        ActivityModule::class,
        ViewModelFactoryModule::class
    ]
)
interface AppComponent : AndroidInjector<AndroidTemplateApp> {


    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

}