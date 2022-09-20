package com.submission.sportapp.core.data.source.local.room

import androidx.room.*
import com.submission.sportapp.core.data.source.local.entity.SportsEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface SportsDao {

    @Query("SELECT * FROM sports")
    fun getAllSports(): Flow<List<SportsEntity>>

    @Query("SELECT * FROM sports WHERE isFavorite = 1")
    fun getFavoriteSports(): Flow<List<SportsEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSports(sports: List<SportsEntity>)

    @Update
    fun updateFavoriteSports(sports: SportsEntity)
}