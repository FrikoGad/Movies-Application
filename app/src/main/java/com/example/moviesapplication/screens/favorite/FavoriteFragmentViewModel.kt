package com.example.moviesapplication.screens.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.moviesapplication.utils.REALIZATION
import com.example.moviesapplication.models.MovieItemModel

class FavoriteFragmentViewModel: ViewModel() {

    fun getAllMovies(): LiveData<List<MovieItemModel>> {
        return REALIZATION.allMovies
    }

}