package com.submission.sportapp.core.data

import com.submission.sportapp.core.data.source.local.LocalDataSource
import com.submission.sportapp.core.data.source.remote.RemoteDataSource
import com.submission.sportapp.core.data.source.remote.network.ApiResponse
import com.submission.sportapp.core.data.source.remote.response.SportResponse
import com.submission.sportapp.core.domain.model.Sports
import com.submission.sportapp.core.domain.repository.ISportsRepository
import com.submission.sportapp.core.utils.AppExecutors
import com.submission.sportapp.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class SportsRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
): ISportsRepository {
    override fun getAllSports(): Flow<Resource<List<Sports>>> =
        object: NetworkBoundResource<List<Sports>, List<SportResponse>>() {
            override fun loadFromDB(): Flow<List<Sports>> {
                return localDataSource.getAllSports().map {
                    DataMapper.mapEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<Sports>?): Boolean =
                data == null || data.isEmpty()

            override suspend fun createCall(): Flow<ApiResponse<List<SportResponse>>> =
                remoteDataSource.getAllSports()

            override suspend fun saveCallResult(data: List<SportResponse>) {
                val sportsList = DataMapper.mapResponseToEntities(data)
                localDataSource.insertSports(sportsList)
            }
        }.asFlow()


    override fun getFavoriteSports(): Flow<List<Sports>> {
        return localDataSource.getFavoriteSports().map {
            DataMapper.mapEntitiesToDomain(it)
        }
    }

    override fun setFavoriteSports(sports: Sports, state: Boolean) {
        val sportsEntity = DataMapper.mapDomainToEntity(sports)
        appExecutors.diskIO().execute{ localDataSource.setFavoriteSports(sportsEntity, state) }
    }

}