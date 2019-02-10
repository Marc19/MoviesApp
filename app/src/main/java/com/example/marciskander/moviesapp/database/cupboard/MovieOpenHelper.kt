package com.example.marciskander.moviesapp.database.cupboard

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.marciskander.moviesapp.data.Movie
import nl.qbusict.cupboard.CupboardBuilder
import nl.qbusict.cupboard.CupboardFactory.cupboard
import nl.qbusict.cupboard.CupboardFactory.setCupboard

class MovieOpenHelper(context: Context) : SQLiteOpenHelper(context, "mymovies.db", null, 1) {

    init {
        setCupboard(CupboardBuilder().useAnnotations().build())
        cupboard().register(Movie::class.java)
    }



    override fun onCreate(db: SQLiteDatabase) {
        cupboard().withDatabase(db).createTables()
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        cupboard().withDatabase(db).dropAllTables()
        cupboard().withDatabase(db).createTables()
    }
}