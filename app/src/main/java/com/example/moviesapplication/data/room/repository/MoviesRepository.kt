package com.example.moviesapplication.data.room.repository

import androidx.lifecycle.LiveData
import com.example.moviesapplication.models.MovieItemModel

interface MoviesRepository {
    val allMovies: LiveData<List<MovieItemModel>>
    suspend fun insertMovie(movieItemModel: MovieItemModel, onSuccess:() -> Unit)
    suspend fun deleteMovie(movieItemModel: MovieItemModel, onSuccess:() -> Unit)

}