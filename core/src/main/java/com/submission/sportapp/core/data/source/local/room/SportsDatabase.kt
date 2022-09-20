package com.submission.sportapp.core.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.submission.sportapp.core.data.source.local.entity.SportsEntity

@Database(entities = [SportsEntity::class], version = 1, exportSchema = false)
abstract class SportsDatabase: RoomDatabase() {

    abstract fun sportsDao(): SportsDao
}