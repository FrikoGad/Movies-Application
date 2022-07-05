package com.example.moviesapplication.utils

import android.content.Context

class SaveShared {

    companion object {

        fun getFavorite(context: Context?, key: String): Boolean {
            val getFavorite = context?.getSharedPreferences(key, Context.MODE_PRIVATE)
            return getFavorite!!.getBoolean(key, false)
        }

        fun setFavorite(context: Context?, key: String, value: Boolean) {
            val setFavorite = context?.getSharedPreferences(key, Context.MODE_PRIVATE)
            setFavorite!!.edit().putBoolean(key, value).apply()
        }
    }
}