package com.example.marciskander.moviesapp.database.sqlite

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.util.Log
import com.example.marciskander.moviesapp.data.Movie

class MoviesDataSourceSqlite (context: Context){

    lateinit var database: SQLiteDatabase
    lateinit var dbHelper: MovieReaderDBHelper

    companion object {
        var moviesDataSourceSqlite: MoviesDataSourceSqlite? = null

        fun getInstance(context: Context) : MoviesDataSourceSqlite{
            if(moviesDataSourceSqlite == null){
                moviesDataSourceSqlite = MoviesDataSourceSqlite(context = context)
            }

            return moviesDataSourceSqlite as MoviesDataSourceSqlite
        }
    }

    init {
        this.dbHelper = MovieReaderDBHelper(context)
    }

    fun open(){
        database = dbHelper.writableDatabase
    }

    fun close(){
        dbHelper.close()
    }

    fun insertMovie(movie: Movie) {
        val values = ContentValues().apply {
            put(MovieContract.MovieEntry.COLUMN_NAME_TITLE, movie.title)
            put(MovieContract.MovieEntry.COLUMN_VOTE_COUNT, movie.vote_count)
            put(MovieContract.MovieEntry.COLUMN_VOTE_AVERAGE, movie.vote_average)
            put(MovieContract.MovieEntry.COLUMN_POSTER_PATH, movie.poster_path)
            put(MovieContract.MovieEntry.COLUMN_OVERVIEW, movie.overview)
        }

        val rowID: Long = database.insert(MovieContract.MovieEntry.TABLE_NAME, null, values)

        Log.d("HOLA", rowID.toString())
    }

    fun getMovies() : List<Movie>{
        val rawQuery: String = "SELECT * FROM movie"

        val cursor: Cursor = database.rawQuery(rawQuery, null)

        var movies: MutableList<Movie> = mutableListOf<Movie>()

        // UNCOMMENT WHEN USING SQLITE
//        while(cursor.moveToNext()) {
//            val movie:Movie = Movie(
//                    cursor.getInt(cursor.getColumnIndex(MovieContract.MovieEntry.COLUMN_VOTE_COUNT)),
//                    cursor.getDouble(cursor.getColumnIndex(MovieContract.MovieEntry.COLUMN_VOTE_AVERAGE)),
//                    cursor.getString(cursor.getColumnIndex(MovieContract.MovieEntry.COLUMN_NAME_TITLE)),
//                    cursor.getString(cursor.getColumnIndex(MovieContract.MovieEntry.COLUMN_POSTER_PATH)),
//                    cursor.getString(cursor.getColumnIndex(MovieContract.MovieEntry.COLUMN_OVERVIEW)) )
//
//            movies.add(movie)
//        }
//
//        cursor.close()
        return movies
    }
}