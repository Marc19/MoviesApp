package com.example.marciskander.moviesapp.view_controller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.example.marciskander.moviesapp.R
import com.example.marciskander.moviesapp.data_controller.DataController
import com.example.marciskander.moviesapp.database.cupboard.MoviesDataSourceCupboard
import com.example.marciskander.moviesapp.database.realm.MoviesDataSourceRealm
//import com.example.marciskander.moviesapp.database.room.MovieDataSourceRoom
import com.example.marciskander.moviesapp.database.sqlite.MoviesDataSourceSqlite
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val dataController: DataController = DataController()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Realm.init(this) // THIS SHOULD BE IN MOVIEAPPLICATION.KT BUT THERE IS AN ERROR THERE :(
        prepareViewSavedButton()
        prepareRecyclerView()
        makeRequest()
    }

    override fun onResume() {
        super.onResume()
        //SQLITE
//        MoviesDataSourceSqlite.getInstance(this).open()

        //REALM
        MoviesDataSourceRealm.open()

    }

    override fun onPause() {
        super.onPause()
        //SQLITE
//        MoviesDataSourceSqlite.getInstance(this).close()

        //REALM
        MoviesDataSourceRealm.close()
    }

    private fun prepareViewSavedButton() {
        log_saved_movies.setOnClickListener {

            //USING SQLITE
//            val movieDataSourceSqlite = MoviesDataSourceSqlite.getInstance(this)
//            val savedMovies = movieDataSourceSqlite.getMovies()
//            Log.d("HOLA", savedMovies.map{ movie -> movie.title }.toString())

            //USING ROOM
//            val movieDataSourceRoom: MovieDataSourceRoom = MovieDataSourceRoom(this)
//            val savedMovies = movieDataSourceRoom.getAllMovies( successHandler = {
//                Log.d("HOLA", it.map{ movie -> movie.title }.toString())
//            })

            //USING CUPBOARD
//            val movieDataSourceCupboard : MoviesDataSourceCupboard = MoviesDataSourceCupboard(this)
//            val savedMovies = movieDataSourceCupboard.getMovies()
//            Log.d("HOLA", savedMovies.map{ movie -> movie.title }.toString())

            //USING REALM
            val savedMovies = MoviesDataSourceRealm.getMovies()
            Log.d("HOLA", savedMovies.map{ movie -> movie.title }.toString())

        }
    }

    private fun prepareRecyclerView() {
        recycle_view.setHasFixedSize(true)
        recycle_view.layoutManager = LinearLayoutManager(this)
    }

    private fun makeRequest() {
        dataController.requestData(successHandler = {
            recycle_view.adapter = MyRecyclerViewAdapter(dataController)
        }, errorHandler = {
            Log.d("HOLA", "Couldn't load movies")
        })
    }


}
