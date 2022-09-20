package com.submission.sportapp.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Sports (
        val sportsId: String,
        val name: String,
        val sportsFormat: String,
        val description: String,
        val image: String,
        val isFavorite: Boolean
        ) : Parcelable