package com.example.moviesapplication.data.retrofit.api

import com.example.moviesapplication.models.MovieItemModel
import com.example.moviesapplication.models.MovieModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface ApiService {
    var listMovies: List<MovieItemModel>


    @Headers(
        "accept: application/json",
        "X-API-KEY: 4ecc9be6-39f4-445a-90b5-8dbae796228f"
    )

    @GET("api/v2.2/films/premieres?year=2022&month=MAY")
    suspend fun getPremierMovie(): Response<MovieModel>

}