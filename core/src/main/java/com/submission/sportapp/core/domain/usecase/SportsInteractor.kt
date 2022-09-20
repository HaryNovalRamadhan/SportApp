package com.submission.sportapp.core.domain.usecase

import com.submission.sportapp.core.domain.model.Sports
import com.submission.sportapp.core.domain.repository.ISportsRepository

class SportsInteractor(private val sportsRepository: ISportsRepository): SportsUseCase {
    override fun getAllSports() = sportsRepository.getAllSports()

    override fun getFavoriteSports() = sportsRepository.getFavoriteSports()

    override fun setFavoriteSports(sports: Sports, state: Boolean) = sportsRepository.setFavoriteSports(sports, state)

}