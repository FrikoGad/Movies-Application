package com.example.moviesapplication.data.room.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.moviesapplication.models.MovieItemModel

@Dao
interface MoviesDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(movieItemModel: MovieItemModel)

    @Delete
    suspend fun delete(movieItemModel: MovieItemModel)

    @Query("SELECT * from")
    fun getAllFavoriteMovies(): LiveData<List<MovieItemModel>>
}