package com.submission.sportapp.core.utils

import com.submission.sportapp.core.data.source.local.entity.SportsEntity
import com.submission.sportapp.core.data.source.remote.response.SportResponse
import com.submission.sportapp.core.domain.model.Sports

object DataMapper {
    fun mapResponseToEntities(input: List<SportResponse>): List<SportsEntity> {
        val sportsList = ArrayList<SportsEntity>()
        input.map {
            val sports = SportsEntity(
                sportsId = it.idSport,
                name = it.strSport,
                sportsFormat = it.strFormat,
                description = it.strSportDescription,
                image = it.strSportThumb,
                isFavorite = false
            )
            sportsList.add(sports)
        }
        return sportsList
    }

    fun mapEntitiesToDomain(input: List<SportsEntity>): List<Sports> =
        input.map {
            Sports(
                sportsId = it.sportsId,
                name = it.name,
                sportsFormat = it.sportsFormat,
                description = it.description,
                image = it.image,
                isFavorite = it.isFavorite
            )
        }

    fun mapDomainToEntity(input: Sports) = SportsEntity(
        sportsId =  input.sportsId,
        name = input.name,
        sportsFormat = input.sportsFormat,
        description = input.description,
        image = input.image,
        isFavorite = input.isFavorite
    )
}