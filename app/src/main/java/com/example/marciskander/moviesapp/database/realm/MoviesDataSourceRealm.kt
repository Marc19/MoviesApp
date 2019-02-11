package com.example.marciskander.moviesapp.database.realm

import android.util.Log
import com.example.marciskander.moviesapp.data.Movie
import io.realm.Realm

object MoviesDataSourceRealm {

    lateinit var realm: Realm

    fun open(){
        realm = Realm.getDefaultInstance()
    }

    fun close(){
        realm.close()
    }

    fun insertMovie(movie: Movie){
        realm.executeTransaction {
            it.insert(movie)
        }

        Log.d("HOLA", movie.id)
    }

    fun getMovies(): List<Movie> {
        return realm.where(Movie::class.java).findAll()
    }
}