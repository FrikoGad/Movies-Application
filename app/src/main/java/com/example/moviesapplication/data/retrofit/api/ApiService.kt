package com.example.moviesapplication.data.retrofit.api

import com.example.moviesapplication.models.Movie
import com.example.moviesapplication.models.MoviesModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface ApiService {

    @Headers(
        "accept: application/json",
        "X-API-KEY: 4ecc9be6-39f4-445a-90b5-8dbae796228f"
    )

    @GET("api/v2.2/films/premieres?year=2022&month=MAY")
    suspend fun getPremierMovie(): Response<MoviesModel>

    @Headers(
        "accept: application/json",
        "X-API-KEY: 4ecc9be6-39f4-445a-90b5-8dbae796228f"
    )

    @GET("api/v2.2/films/{id}")
    suspend fun getMovie(@Path("id") movieId: Int): Response<Movie>

}