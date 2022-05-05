package com.example.moviesapplication.screens.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesapplication.data.retrofit.RetrofitRepository
import com.example.moviesapplication.models.MovieModel
import kotlinx.coroutines.launch
import retrofit2.Response

class MainFragmentViewModel : ViewModel() {
    private val repository = RetrofitRepository()
    val myMovies: MutableLiveData<Response<MovieModel>> = MutableLiveData()

    fun getMovies() {
        viewModelScope.launch {
            try{
                myMovies.value = repository.getMovie()
            }catch (e: Exception) {
                Log.e("ERROR", e.message.toString())
            }

        }
    }
}