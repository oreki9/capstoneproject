package com.kumastudio.capstoneproject.core.data.source.local.entity


import androidx.annotation.Keep
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Keep
@Entity(tableName = "movies")
data class MovieEntity(
        @PrimaryKey
        @NonNull
        @ColumnInfo(name = "movieId")
        var movieId: String,

        @ColumnInfo(name = "name")
        var name: String,

        @ColumnInfo(name = "description")
        var description: String,

        @ColumnInfo(name = "image")
        var image: String,

        @ColumnInfo(name = "isFavorite")
        var isFavorite: Boolean = false
)
