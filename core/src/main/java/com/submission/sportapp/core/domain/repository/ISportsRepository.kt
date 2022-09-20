package com.submission.sportapp.core.domain.repository

import com.submission.sportapp.core.data.Resource
import com.submission.sportapp.core.domain.model.Sports
import kotlinx.coroutines.flow.Flow

interface ISportsRepository {

    fun getAllSports(): Flow<Resource<List<Sports>>>

    fun getFavoriteSports(): Flow<List<Sports>>

    fun setFavoriteSports(sports: Sports, state: Boolean)

}