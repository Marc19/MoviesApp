//package com.example.marciskander.moviesapp.database.room
//
//import android.arch.persistence.room.Database
//import android.arch.persistence.room.Room
//import android.arch.persistence.room.RoomDatabase
//import android.content.Context
//import com.example.marciskander.moviesapp.data.Movie
//
//@Database(entities = arrayOf(Movie::class), version = 1)
//abstract class MovieDatabase : RoomDatabase() {
//
//    companion object {
//        private var INSTANCE: MovieDatabase? = null
//
//        fun getInstance(context: Context) : MovieDatabase {
//            if(INSTANCE == null){
//                INSTANCE  = Room.databaseBuilder(
//                        context,
//                        MovieDatabase::class.java, "movie"
//                ).build()
//            }
//
//            return INSTANCE as MovieDatabase
//        }
//    }
//
//    abstract fun movieDao(): MovieDao
//
//
//}