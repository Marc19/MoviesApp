package com.example.marciskander.moviesapp.database.sqlite

import android.provider.BaseColumns

object MovieContract {

    const val SQL_CREATE_ENTRIES =
            "CREATE TABLE ${MovieEntry.TABLE_NAME} (" +
                    "${BaseColumns._ID} INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "${MovieEntry.COLUMN_NAME_TITLE} TEXT," +
                    "${MovieEntry.COLUMN_VOTE_COUNT} INTEGER," +
                    "${MovieEntry.COLUMN_VOTE_AVERAGE} REAL," +
                    "${MovieEntry.COLUMN_POSTER_PATH} TEXT," +
                    "${MovieEntry.COLUMN_OVERVIEW} TEXT)"

    const val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS ${MovieEntry.TABLE_NAME}"

    object MovieEntry : BaseColumns {
        const val TABLE_NAME = "movie"
        const val COLUMN_NAME_TITLE = "title"
        const val COLUMN_VOTE_COUNT = "vote_count"
        const val COLUMN_VOTE_AVERAGE = "vote_average"
        const val COLUMN_POSTER_PATH = "poster_path"
        const val COLUMN_OVERVIEW = "overview"
    }
}