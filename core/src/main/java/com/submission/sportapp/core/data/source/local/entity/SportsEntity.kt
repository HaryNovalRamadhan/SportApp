package com.submission.sportapp.core.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Sports")
data class SportsEntity (
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "sportsId")
    var sportsId: String,

    @ColumnInfo(name = "name")
    var name:String,

    @ColumnInfo(name = "sportsFormat")
    var sportsFormat: String,

    @ColumnInfo(name = "description")
    var description: String,

    @ColumnInfo(name = "image")
    var image: String,

    @ColumnInfo(name = "isFavorite")
    var isFavorite: Boolean = false
)