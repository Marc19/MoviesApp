package com.example.marciskander.moviesapp.view_controller

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.marciskander.moviesapp.R
import com.example.marciskander.moviesapp.data_controller.DataController
import com.example.marciskander.moviesapp.database.cupboard.MoviesDataSourceCupboard
import com.example.marciskander.moviesapp.database.realm.MoviesDataSourceRealm
import com.squareup.picasso.Picasso


class MyRecyclerViewAdapter(val dataController: DataController) : RecyclerView.Adapter<MyRecyclerViewAdapter.MovieViewHolder>() {

    private val IMAGE_BASE_URL: String = "https://image.tmdb.org/t/p/w500"
    lateinit var context: Context

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MovieViewHolder {
        context = p0.context
        val mainView = LayoutInflater.from(p0.context).inflate(R.layout.movie_item, p0, false)
        return MovieViewHolder(mainView)
    }

    override fun getItemCount(): Int {
        return dataController.movies.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.movieTitleTextView.text = dataController.getMovieTitleAtPosition(position)
        holder.movieRatingTextView.text = dataController.getMovieRatingAtPosition(position)

        val imageURL: String = IMAGE_BASE_URL + dataController.getMovieImagePath(position)

        //LOAD IMAGE WITH PICASSO
        Picasso.get().load(imageURL).into(holder.movieImageView)

        //LOAD IMAGE WITH GLIDE
//        val options = RequestOptions()
//        options.circleCrop()
//        Glide.with(context).load(imageURL).apply(options).into(holder.movieImageView)

        holder.saveButton.setOnClickListener {
            //USING SQLITE. (Also DON'T FORGET TO call .open() in main activity's onResume() and .close() in onPause())
//            val movieDataSourceSqlite: MoviesDataSourceSqlite = MoviesDataSourceSqlite.getInstance(context)
//            movieDataSourceSqlite.insertMovie(dataController.movies[position])

            //USING ROOM
//            val movieDataSourceRoom: MovieDataSourceRoom = MovieDataSourceRoom(context)
//            movieDataSourceRoom.insertMovie(dataController.movies[position])

            //USING CUPBOARD
//            val movieDataSourceCupboard : MoviesDataSourceCupboard = MoviesDataSourceCupboard(context)
//            movieDataSourceCupboard.insertMovie(dataController.movies[position])

            //USING REALM
            MoviesDataSourceRealm.insertMovie(dataController.movies[position])
        }
    }

    class MovieViewHolder(val mainView: View) : RecyclerView.ViewHolder(mainView) {
        val movieImageView: ImageView
        val movieTitleTextView: TextView
        val movieRatingTextView: TextView
        val saveButton: Button

        init {
            movieImageView= mainView.findViewById(R.id.movie_image_view)
            movieTitleTextView = mainView.findViewById(R.id.movie_title)
            movieRatingTextView = mainView.findViewById(R.id.movie_rating)
            saveButton = mainView.findViewById(R.id.save_button)
        }
    }

}