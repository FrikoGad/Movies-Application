package com.example.moviesapplication.data.room.repository

import androidx.lifecycle.LiveData
import com.example.moviesapplication.data.room.dao.MoviesDao
import com.example.moviesapplication.models.MovieItemModel

class MoviesRepositoryRealization(private val moviesDao: MoviesDao) : MoviesRepository {
    override val allMovies: LiveData<List<MovieItemModel>>
        get() = moviesDao.getAllFavoriteMovies()

    override suspend fun insertMovie(movieItemModel: MovieItemModel, onSuccess: () -> Unit) {
        moviesDao.insert(movieItemModel)
        onSuccess()
    }

    override suspend fun deleteMovie(movieItemModel: MovieItemModel, onSuccess: () -> Unit) {
        moviesDao.delete(movieItemModel)
        onSuccess()
    }
}