package com.example.movie.data.api

import com.example.movie.data.pojo.MarvelDetails
import com.example.movie.data.pojo.MovieDetails
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


public object MovieClient {
    private final val API_KEy = "4312be306154acabe16a5c5adbc9a6ba"
    private const val BASE_URL = "https://api.themoviedb.org/3/"
    private var movieInterFace: MovieInterFace? = null


    val INSTANT : MovieInterFace by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://simplifiedcoding.net/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        retrofit.create(MovieInterFace::class.java)
    }


   public fun getMovies(): Call<List<MarvelDetails>>? {
        return movieInterFace?.getMovie()
    }
 }

