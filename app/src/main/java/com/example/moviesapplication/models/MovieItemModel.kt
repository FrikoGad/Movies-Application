package com.example.moviesapplication.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "movie_table")
data class MovieItemModel(
    @PrimaryKey(autoGenerate = true)
    val kinopoiskId: Int,
    val duration: Int,
    val nameEn: String,
    val posterUrl: String,
    val year: Int,

    @ColumnInfo
    val nameRu: String,

    @ColumnInfo
    val posterUrlPreview: String,

    @ColumnInfo
    val premiereRu: String

) : Serializable