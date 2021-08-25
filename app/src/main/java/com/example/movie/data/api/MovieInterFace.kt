package com.example.movie.data.api

import com.example.movie.data.pojo.MarvelDetails
import com.example.movie.data.pojo.MovieDetails
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieInterFace {
    @GET("demos/marvel/")
    fun getMovie() :Call<List<MarvelDetails>>
}