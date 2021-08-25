package com.example.movie.data.pojo

import com.google.gson.annotations.SerializedName

class MovieDetails {
    @SerializedName("id")
    val id:Int ? = null
    @SerializedName("original_language")
    val language:String?=null
    @SerializedName("original_title")
    val original_title:String?=null
    @SerializedName("overview")
    val overview:String?=null
    @SerializedName("title")
    val title:String?=null
    @SerializedName("release_date")
    val release_date:String?=null
    @SerializedName("publisher")
    val publisher:String?=null
    @SerializedName("poster_path")
    val poster_path:String?=null
    @SerializedName("backdrop_path")
    val backdrop_path:String?=null
}