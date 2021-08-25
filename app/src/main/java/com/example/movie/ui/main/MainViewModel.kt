package com.example.movie.ui.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movie.data.api.MovieClient
import com.example.movie.data.pojo.MarvelDetails
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel:ViewModel() {
    var moviesMutableLiveData:MutableLiveData<List<MarvelDetails>> = MutableLiveData()

    public fun getMovie(){
        val data = MovieClient.INSTANT
        data.getMovie().enqueue(object : Callback<List<MarvelDetails>?> {
            override fun onResponse(
                call: Call<List<MarvelDetails>?>,
                response: Response<List<MarvelDetails>?>
            ) {

                    //                val  responseBody = response.body()
                    //                if (responseBody != null) {
                    //                    for (data1 in responseBody){
                    //                        moviesMutableLiveData.value= listOf(data1)
                    //                    }
                    //                }
                moviesMutableLiveData.postValue(response.body())
            }

            override fun onFailure(call: Call<List<MarvelDetails>?>, t: Throwable) {
                Log.d("onFailure",t.message.toString())
            }
        })
    }

}