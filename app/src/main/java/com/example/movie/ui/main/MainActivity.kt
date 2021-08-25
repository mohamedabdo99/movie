package com.example.movie.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.movie.R
import com.example.movie.data.api.MovieInterFace
import com.example.movie.data.pojo.MarvelDetails
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    lateinit var mainViewModel: MainViewModel
    private lateinit var linearLayoutManager: LinearLayoutManager
    private val myAdapter by lazy { MainAdapter() }

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecyclerView()
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        mainViewModel.getMovie()
        mainViewModel.moviesMutableLiveData.observe(this, Observer { response->
            if (response != null){
                recyclerView.adapter = myAdapter
                myAdapter.setList(response)
            }
        })
    }

    private fun initRecyclerView() {
        linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager

    }
    private fun getData() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://simplifiedcoding.net/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MovieInterFace::class.java)

        val data = retrofit.getMovie()

        data.enqueue(object : Callback<List<MarvelDetails>?> {
            override fun onResponse(call: Call<List<MarvelDetails>?>, response: Response<List<MarvelDetails>?>) {
                val  responseBody = response.body()
                if (responseBody != null) {
                    for (data in responseBody){
                        Log.d("responseBody",data.name.toString())
                    }
                }
            }
            override fun onFailure(call:Call<List<MarvelDetails>?>, t: Throwable) {
                Log.d("responseBody",t.message.toString())
            }
        })
    }
}