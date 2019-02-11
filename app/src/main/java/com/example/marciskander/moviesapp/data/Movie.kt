package com.example.marciskander.moviesapp.data


import io.realm.RealmObject
import java.util.*


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

//data class Movie(var _id:java.lang.Long, val vote_count: Int, val vote_average: Double, val title: String,
//                 val poster_path: String, val overview: String) {
//
//}

// THE MODEL FOR REALM

open class Movie(@io.realm.annotations.PrimaryKey var id:String? = UUID.randomUUID().toString(),
                 var vote_count: Int? = null,
                 var vote_average: Double? = null,
                 var title: String? = null,
                 var poster_path: String? = null,
                 var overview: String? = null) : RealmObject(){

    constructor() : this(null,null,null,null,null,null){

    }

}