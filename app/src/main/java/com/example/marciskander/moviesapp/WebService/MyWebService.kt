package com.example.marciskander.moviesapp.WebService

import com.example.marciskander.moviesapp.data.Result
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface MyWebService {

    companion object {
        private const val BASE_URL: String = "https://api.themoviedb.org/3/discover/"


        private const val FEED: String = "movie?api_key=c0942bf1304adbfe5856fdba92bca533&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=false&page=1"

        val retrofit: Retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
    }



    @GET(FEED)
    fun getMovies() : Call<Result>
}