package com.example.moviesapplication.data.room.repository

import com.example.moviesapplication.models.MovieItemModel

interface MoviesRepository {
    suspend fun getMovies(): List<MovieItemModel>
    suspend fun insertMovie(movieItemModel: MovieItemModel, onSuccess: () -> Unit)
    suspend fun deleteMovie(movieItemModel: MovieItemModel, onSuccess: () -> Unit)

}