package com.example.marciskander.moviesapp.database.cupboard

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.util.Log
import com.example.marciskander.moviesapp.data.Movie
import nl.qbusict.cupboard.CupboardFactory.cupboard
import nl.qbusict.cupboard.CupboardFactory.cupboard



class MoviesDataSourceCupboard (context: Context){

    lateinit var database: SQLiteDatabase
    lateinit var dbHelper: MovieOpenHelper

    companion object {
        var moviesDataSourceCupboard: MoviesDataSourceCupboard? = null

        fun getInstance(context: Context): MoviesDataSourceCupboard {
            if (moviesDataSourceCupboard == null) {
                moviesDataSourceCupboard = MoviesDataSourceCupboard(context = context)
            }

            return moviesDataSourceCupboard as MoviesDataSourceCupboard
        }
    }

    init {
        this.dbHelper = MovieOpenHelper(context)
        database = dbHelper.writableDatabase
    }


    fun insertMovie(movie: Movie) {
        val rowID = cupboard().withDatabase(database).put(movie)

        Log.d("HOLA", rowID.toString() + " from cupboard")
    }

    //NOT WORKING
    fun getMovies(): List<Movie> {
//        val movies = cupboard().withDatabase(database).query<Movie>(Movie::class.java).list()

        val movies = listOf<Movie>(cupboard().withDatabase(database).get(Movie::class.java, 1L))
        return movies
    }

}