package com.learn.androidtemplate.di.home

import com.learn.androidtemplate.network.home.HomeApi
import com.learn.androidtemplate.db.AppDatabase
import com.learn.androidtemplate.repository.HomeRepository
import com.learn.androidtemplate.ui.home.HomeAdapter
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class HomeModule {

    @Provides
    fun providesHomeRepository(homeApi: HomeApi, db: AppDatabase): HomeRepository = HomeRepository(homeApi, db)

    @Provides
    fun providesApi(retrofit: Retrofit): HomeApi = retrofit.create(HomeApi::class.java)

}