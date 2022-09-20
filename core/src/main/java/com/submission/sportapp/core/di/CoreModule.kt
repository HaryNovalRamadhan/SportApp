package com.submission.sportapp.core.di

import androidx.room.Room
import com.submission.sportapp.core.data.SportsRepository
import com.submission.sportapp.core.data.source.local.LocalDataSource
import com.submission.sportapp.core.data.source.local.room.SportsDatabase
import com.submission.sportapp.core.data.source.remote.RemoteDataSource
import com.submission.sportapp.core.data.source.remote.network.ApiService
import com.submission.sportapp.core.domain.repository.ISportsRepository
import com.submission.sportapp.core.utils.AppExecutors
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


val databaseModule = module {
    factory { get<SportsDatabase>().sportsDao() }
    single {
        Room.databaseBuilder(
            androidContext(),
            SportsDatabase::class.java, "Sports.db"
        ).fallbackToDestructiveMigration().build()
    }
}

val networkModule = module {
    single {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .build()
    }
    single {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.thesportsdb.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
        retrofit.create(ApiService::class.java)
    }
}

val repositoryModule = module {
    single { LocalDataSource(get()) }
    single { RemoteDataSource(get()) }
    factory { AppExecutors() }
    single<ISportsRepository> {
        SportsRepository(
            get(),
            get(),
            get()
        )
    }
}