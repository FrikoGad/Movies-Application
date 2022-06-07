package com.example.moviesapplication.screens.detail

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesapplication.REALIZATION
import com.example.moviesapplication.data.retrofit.RetrofitRepository
import com.example.moviesapplication.models.Movie
import com.example.moviesapplication.models.MovieItemModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class DetailViewModel: ViewModel() {

    private val repository = RetrofitRepository()
    val myMovie: MutableLiveData<Response<Movie>> = MutableLiveData()

    fun insert(movieItemModel: MovieItemModel, onSuccess:() -> Unit) =
        viewModelScope.launch(Dispatchers.IO) {
            REALIZATION.insertMovie(movieItemModel){
                onSuccess()
            }
        }

    fun delete(movieItemModel: MovieItemModel, onSuccess:() -> Unit) =
        viewModelScope.launch(Dispatchers.IO) {
            REALIZATION.deleteMovie(movieItemModel){
                onSuccess()
            }
        }

    fun getMovieRetrofit(movieId: Int) {
        viewModelScope.launch {
            try {
                myMovie.value = repository.getMovie(movieId)
            } catch (e: Exception) {
                Log.e("ERROR", e.message.toString())
            }
        }
    }
}