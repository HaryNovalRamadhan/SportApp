package com.submission.sportapp.core.domain.usecase

import com.submission.sportapp.core.data.Resource
import com.submission.sportapp.core.domain.model.Sports
import kotlinx.coroutines.flow.Flow

interface SportsUseCase {
    fun getAllSports(): Flow<Resource<List<Sports>>>
    fun getFavoriteSports(): Flow<List<Sports>>
    fun setFavoriteSports(sports: Sports, state: Boolean)
}