package com.example.moviesapplication.screens.main

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.moviesapplication.data.retrofit.RetrofitRepository
import com.example.moviesapplication.data.room.MoviesRoomDatabase
import com.example.moviesapplication.data.room.repository.MoviesRepositoryRealization
import com.example.moviesapplication.models.MovieModel
import kotlinx.coroutines.launch
import retrofit2.Response

class MainFragmentViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = RetrofitRepository()
    lateinit var realization: MoviesRepositoryRealization
    val myMovies: MutableLiveData<Response<MovieModel>> = MutableLiveData()

    val context = application

    fun getMoviesRetrofit() {
        viewModelScope.launch {
            try {
                myMovies.value = repository.getMovie()
            } catch (e: Exception) {
                Log.e("ERROR", e.message.toString())
            }

        }
    }

    fun initDatabase() {
        val daoMovie = MoviesRoomDatabase.getInstance(context).getMovieDao()
        realization = MoviesRepositoryRealization(daoMovie)
    }
}