package com.example.marciskander.moviesapp.data_controller

import com.example.marciskander.moviesapp.WebService.MyWebService
import com.example.marciskander.moviesapp.data.Movie
import com.example.marciskander.moviesapp.data.Result
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DataController {

    lateinit var movies : List<Movie>

    fun requestData(successHandler: (List<Movie>) -> Unit, errorHandler: () -> Unit) {

        val webService: MyWebService = MyWebService.retrofit.create(MyWebService::class.java)
        val call: Call<Result> = webService.getMovies()

        call.enqueue(object : Callback<Result> {
            override fun onFailure(call: Call<Result>?, t: Throwable?) {
//                Log.d("HOLA"  , t.toString())
                errorHandler()
            }

            override fun onResponse(call: Call<Result>?, response: Response<Result>?) {
//                Log.d("HOLA", response!!.body().toString())
                movies = response!!.body()!!.results

                successHandler(movies)
            }
        })
    }

    fun getMovieTitleAtPosition(position: Int): String {
        return movies[position].title
    }

    fun getMovieRatingAtPosition(position: Int): String {
        return movies[position].vote_average.toString()
    }

    fun getMovieImagePath(position: Int): String{
        return movies[position].poster_path
    }
}
