package com.submission.sportapp.di

import com.submission.sportapp.core.domain.usecase.SportsInteractor
import com.submission.sportapp.core.domain.usecase.SportsUseCase
import com.submission.sportapp.ui.detail.DetailViewModel
import com.submission.sportapp.ui.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val useCaseModule = module {
    factory<SportsUseCase> { SportsInteractor(get()) }
}

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { DetailViewModel(get()) }
}