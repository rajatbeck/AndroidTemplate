package com.learn.androidtemplate.di

import android.app.Application
import androidx.room.Room
import com.learn.androidtemplate.network.home.HomeApi
import com.learn.androidtemplate.repository.AppDatabase
import com.learn.androidtemplate.repository.HomeRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {



    @Singleton
    @Provides
    fun providesRoomDb(application: Application): AppDatabase {
        return Room.databaseBuilder(
            application,
            AppDatabase::class.java, "database-name"
        ).build()
    }


}