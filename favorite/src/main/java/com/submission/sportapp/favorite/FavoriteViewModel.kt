package com.submission.sportapp.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.submission.sportapp.core.domain.usecase.SportsUseCase

class FavoriteViewModel(sportsUseCase: SportsUseCase): ViewModel() {
    val favoriteSports = sportsUseCase.getFavoriteSports().asLiveData()
}