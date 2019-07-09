package com.learn.androidtemplate.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.learn.androidtemplate.db.Feed
import com.learn.androidtemplate.db.FeedDao

@Database(entities = arrayOf(Feed::class), version = 1)
abstract class AppDatabase () : RoomDatabase() {
    abstract fun feedDao(): FeedDao
}