package com.submission.sportapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.submission.sportapp.core.domain.usecase.SportsUseCase

class HomeViewModel(sportsUseCase: SportsUseCase) : ViewModel() {
    val sports = sportsUseCase.getAllSports().asLiveData()
}