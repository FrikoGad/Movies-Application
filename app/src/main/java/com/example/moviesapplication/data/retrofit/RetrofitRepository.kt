package com.example.moviesapplication.data.retrofit

import com.example.moviesapplication.data.retrofit.api.RetrofitInstance
import com.example.moviesapplication.models.MovieItemModel
import com.example.moviesapplication.models.MoviesModel
import retrofit2.Response

class RetrofitRepository {
    suspend fun getMovies(): Response<MoviesModel> {
        return RetrofitInstance.api.getPremierMovie()
    }

    suspend fun getMovie(movieId: Int): Response<MovieItemModel> {
        return RetrofitInstance.api.getMovie(movieId)
    }
}