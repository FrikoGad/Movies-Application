package com.example.moviesapplication.data.room.dao

import androidx.room.*
import com.example.moviesapplication.models.MovieItemModel

@Dao
interface MoviesDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(movieItemModel: MovieItemModel)

    @Delete
    suspend fun delete(movieItemModel: MovieItemModel)

    @Query("SELECT * from movie_table")
    fun getAll(): List<MovieItemModel>
}