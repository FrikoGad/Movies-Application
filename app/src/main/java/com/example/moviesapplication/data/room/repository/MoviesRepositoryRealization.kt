package com.example.moviesapplication.data.room.repository

import com.example.moviesapplication.data.room.dao.MoviesDao
import com.example.moviesapplication.models.MovieItemModel

class MoviesRepositoryRealization(private val moviesDao: MoviesDao) : MoviesRepository {
    override suspend fun getMovies() : List<MovieItemModel> {
        return moviesDao.getAll()
    }

    override suspend fun insertMovie(movieItemModel: MovieItemModel, onSuccess: () -> Unit) {
        moviesDao.insert(movieItemModel)
        onSuccess()
    }

    override suspend fun deleteMovie(movieItemModel: MovieItemModel, onSuccess: () -> Unit) {
        moviesDao.delete(movieItemModel)
        onSuccess()
    }
}