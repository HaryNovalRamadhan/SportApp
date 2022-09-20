package com.submission.sportapp.core.data.source.remote.network

import com.submission.sportapp.core.data.source.remote.response.ListSportResponse
import retrofit2.http.GET

interface ApiService {
    @GET("api/v1/json/2/all_sports.php")
    suspend fun getList(): ListSportResponse
}