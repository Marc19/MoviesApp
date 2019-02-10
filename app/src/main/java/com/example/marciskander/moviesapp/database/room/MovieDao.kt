//package com.example.marciskander.moviesapp.database.room
//
//import android.arch.persistence.room.Dao
//import android.arch.persistence.room.Delete
//import android.arch.persistence.room.Insert
//import android.arch.persistence.room.Query
//import com.example.marciskander.moviesapp.data.Movie
//
//@Dao
//interface MovieDao {
//
//    @Query("SELECT * FROM movie")
//    fun getAll(): List<Movie>
//
//    @Query("SELECT * FROM movie WHERE id IN (:movieIds)")
//    fun loadAllByIds(movieIds: IntArray): List<Movie>
//
//    @Query("SELECT * FROM movie WHERE title LIKE :title LIMIT 1")
//    fun findByName(title: String): Movie
//
//    @Insert
//    fun insertAll(vararg movies: Movie)
//
//    @Delete
//    fun delete(movie: Movie)
//}