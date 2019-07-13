package com.learn.androidtemplate.di

import android.app.Application
import androidx.room.Room
import com.learn.androidtemplate.db.AppDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.learn.androidtemplate.GlideApp
import com.learn.androidtemplate.GlideRequests
import com.learn.androidtemplate.R


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