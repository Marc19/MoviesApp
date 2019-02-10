package com.example.marciskander.moviesapp.data

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey


// THE MODEL WITHOUT CHANGES //

//data class Movie(val vote_count: Int, val vote_average: Double, val title: String,
//                 val poster_path: String, val overview: String) {
//
//}


// THE MODEL FOR ROOM //

//@Entity(tableName = "movie")
//data class Movie(@PrimaryKey(autoGenerate = true) var id: Int, val vote_count: Int, val vote_average: Double, val title: String,
//                 val poster_path: String, val overview: String) {
//
//
//}

// THE MODEL FOR CUPBOARD

data class Movie(var _id:java.lang.Long, val vote_count: Int, val vote_average: Double, val title: String,
                 val poster_path: String, val overview: String) {

}