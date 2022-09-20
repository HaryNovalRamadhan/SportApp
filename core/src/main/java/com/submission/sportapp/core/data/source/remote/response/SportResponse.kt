package com.submission.sportapp.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class SportResponse (
    @field:SerializedName("idSport")
    val idSport: String,

    @field:SerializedName("strFormat")
    val strFormat: String,

    @field:SerializedName("strSport")
    val strSport: String,

    @field:SerializedName("strSportIconGreen")
    val strSportIconGreen: String,

    @field:SerializedName("strSportThumb")
    val strSportThumb: String,

    @field:SerializedName("strSportDescription")
    val strSportDescription: String
        )