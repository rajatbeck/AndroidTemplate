package com.learn.androidtemplate.repository

import androidx.room.Database
import androidx.room.RoomDatabase
import javax.inject.Inject

@Database(entities = arrayOf(Feed::class), version = 1)
abstract class AppDatabase () : RoomDatabase() {
    abstract fun feedDao(): FeedDao
}