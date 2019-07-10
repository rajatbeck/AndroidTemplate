package com.learn.androidtemplate.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.Flowable

@Dao
interface FeedDao {
    @Query("SELECT * FROM feed")
    fun getAllFeed(): Flowable<List<Feed>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(feed: List<Feed>)
}