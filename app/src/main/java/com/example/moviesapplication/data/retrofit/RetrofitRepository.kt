package com.example.moviesapplication.data.retrofit

import com.example.moviesapplication.data.retrofit.api.RetrofitInstance
import com.example.moviesapplication.models.MovieModel
import retrofit2.Response

class RetrofitRepository {
    suspend fun getMovie(): Response<MovieModel> {
        return RetrofitInstance.api.getPremierMovie()
    }
}