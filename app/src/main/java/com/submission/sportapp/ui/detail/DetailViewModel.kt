package com.submission.sportapp.ui.detail

import androidx.lifecycle.ViewModel
import com.submission.sportapp.core.domain.model.Sports
import com.submission.sportapp.core.domain.usecase.SportsUseCase

class DetailViewModel(private val sportsUseCase: SportsUseCase): ViewModel() {
    fun setFavoriteSports(sports: Sports, newStatus:Boolean) =
        sportsUseCase.setFavoriteSports(sports, newStatus)
}