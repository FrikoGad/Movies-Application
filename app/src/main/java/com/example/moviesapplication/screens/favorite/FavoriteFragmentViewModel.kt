package com.example.moviesapplication.screens.favorite

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesapplication.utils.REALIZATION
import com.example.moviesapplication.models.MovieItemModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FavoriteFragmentViewModel: ViewModel() {

    val favoriteMovies: MutableLiveData<List<MovieItemModel>> = MutableLiveData()

    fun getAllMovies() {
        viewModelScope.launch(Dispatchers.IO) {
            favoriteMovies.postValue(REALIZATION.getMovies())
        }
    }

}