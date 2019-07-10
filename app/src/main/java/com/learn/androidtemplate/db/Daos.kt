package com.learn.androidtemplate.db

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface FeedDao {
    @Query("SELECT * FROM feed")
    fun getAllFeed(): DataSource.Factory<Int,Feed>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(feed: List<Feed>)
}