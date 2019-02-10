//package com.example.marciskander.moviesapp.database.room
//
//import android.content.Context
//import android.os.Handler
//import android.os.Looper
//import com.example.marciskander.moviesapp.data.Movie
//
//class MovieDataSourceRoom (context: Context){
//    var  movieDao: MovieDao
//
//    init {
//        val db = MovieDatabase.getInstance(context)
//        movieDao = db.movieDao()
//    }
//
//    fun insertMovie(movie: Movie){
//        object : Thread(){
//            override fun run() {
//                movieDao.insertAll(movie)
//            }
//        }.start()
//
//    }
//
//    fun getAllMovies( successHandler: (List<Movie>) -> Unit ) {
//        object : Thread(){
//            override fun run() {
//                val movies = movieDao.getAll()
//                Handler(Looper.getMainLooper()).post {
//                    successHandler(movies)
//                }
//            }
//        }.start()
//    }
//}