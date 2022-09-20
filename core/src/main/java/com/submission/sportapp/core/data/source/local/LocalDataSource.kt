package com.submission.sportapp.core.data.source.local

import com.submission.sportapp.core.data.source.local.entity.SportsEntity
import com.submission.sportapp.core.data.source.local.room.SportsDao
import kotlinx.coroutines.flow.Flow

class LocalDataSource(private val sportsDao: SportsDao) {

    fun getAllSports(): Flow<List<SportsEntity>> = sportsDao.getAllSports()

    fun getFavoriteSports(): Flow<List<SportsEntity>> = sportsDao.getFavoriteSports()

    suspend fun insertSports(sportsList: List<SportsEntity>) = sportsDao.insertSports(sportsList)

    fun setFavoriteSports(sports: SportsEntity, newState: Boolean){
        sports.isFavorite = newState
        sportsDao.updateFavoriteSports(sports)
    }
}