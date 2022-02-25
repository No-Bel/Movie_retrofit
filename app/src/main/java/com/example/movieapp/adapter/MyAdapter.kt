package com.example.movieapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.R
import kotlinx.android.synthetic.main.movie_row.view.*

class MyAdapter: RecyclerView.Adapter<MyAdapter.MyViewHolder>(){

    private var movieName = arrayOf("Movie1","Movie2","Movie3","Movie4","Movie5",
        "Movie6","Movie7","Movie8","Movie9","Movie10")
    private var movieOverview = arrayOf("6.6", "6.6","6.6","6.6","6.6","6.6","6.6","6.6","6.6","6.6")
    private var movieImg = intArrayOf(R.mipmap.img, R.mipmap.img, R.mipmap.img, R.mipmap.img,
        R.mipmap.img, R.mipmap.img,R.mipmap.img,R.mipmap.img,R.mipmap.img,R.mipmap.img)

    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.movie_row, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItemName = movieName[position]
        val currentItemOverview = movieOverview[position]
        holder.itemView.movie_name.text = currentItemName
        holder.itemView.vote_average.text = currentItemOverview
        holder.itemView.item_holder_img.setImageResource(movieImg[position])
    }

    override fun getItemCount() = movieName.size

    private var listenerGoMovieScreenFragment: GoToMovieFragment? = null

    interface GoToMovieFragment {
        fun goToMovieFragment()
    }

}