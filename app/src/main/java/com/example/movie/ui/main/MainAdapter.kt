package com.example.movie.ui.main

import android.os.Parcelable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.movie.R
import com.example.movie.data.pojo.MarvelDetails
import com.squareup.picasso.Picasso

class MainAdapter  : RecyclerView.Adapter<MainAdapter.ViewHolder>(){

        var movieList:List<MarvelDetails> = ArrayList()

     fun setList(movieList:List<MarvelDetails>){
        this.movieList = movieList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recycler,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: MainAdapter.ViewHolder, position: Int)
    {
        holder.tvName.text = movieList[position].name.toString()
        holder.itemPublisher.text = movieList[position].publisher.toString()
        Picasso.get()
            .load(movieList[position].imageurl)
            .placeholder(R.drawable.wait)
            .into(holder.imageView)
    }

    override fun getItemCount(): Int {
     return  movieList.size
    }

    inner class ViewHolder(itemview:View) : RecyclerView.ViewHolder(itemview)
    {
        var imageView:ImageView
        var tvName:TextView
        var itemPublisher:TextView

        init {
            imageView = itemview.findViewById(R.id.ivPoster)
            tvName = itemview.findViewById(R.id.tvName)
            itemPublisher = itemview.findViewById(R.id.tvPublisher)
        }

    }

}