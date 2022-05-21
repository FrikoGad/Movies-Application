package com.example.moviesapplication

import android.content.Context
import android.preference.PreferenceManager
import com.example.moviesapplication.data.room.repository.MoviesRepositoryRealization

lateinit var  MAIN: MainActivity
const val BASE_URL = "https://kinopoiskapiunofficial.tech/"
lateinit var REALIZATION: MoviesRepositoryRealization

//@Suppress("DEPRECATION")
//class SaveShared {
//
//    companion object{
//
//        fun getFavorite(context: Context?, key: String): Boolean {
//            val getFavoriteShared = PreferenceManager.getDefaultSharedPreferences(context)
//            return getFavoriteShared.getBoolean(key, false)
//        }
//
//        fun setFavorite(context: Context?, key: String, value: Boolean) {
//            val getFavoriteShared = PreferenceManager.getDefaultSharedPreferences(context)
//            getFavoriteShared.edit().putBoolean(key, value).apply()
//        }
//
//    }
//
//}