package com.submission.sportapp

import android.app.Application
import com.submission.sportapp.core.di.databaseModule
import com.submission.sportapp.core.di.networkModule
import com.submission.sportapp.core.di.repositoryModule
import com.submission.sportapp.di.useCaseModule
import com.submission.sportapp.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@MyApplication)
            modules(
                listOf(
                    databaseModule,
                    networkModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule
                )
            )
        }
    }
}