package com.example.movieapp.adapter.similarMovieAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieapp.R
import com.example.movieapp.const.Constants
import com.example.movieapp.moviedata.MovieData
import kotlinx.android.synthetic.main.movie_row.view.*

class SimilarAdapter: RecyclerView.Adapter<SimilarAdapter.SimilarViewHolder>() {

    private var similarList = ArrayList<MovieData>()

    inner class SimilarViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun similarMovieDetail(movie: MovieData) {
            itemView.setOnClickListener {
                listenerSimilarDetailScreen?.similarDetailScreen(movie)
            }

        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimilarViewHolder {
        return SimilarViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.similar_movie_row, parent, false)
        )
    }

    override fun onBindViewHolder(holder: SimilarViewHolder, position: Int) {

        val currentItem = similarList[position]

        val movieImg = currentItem.backdropPath
        val imageBaseUrl = Constants.IMAGE_BASE_URL
        //my url || image_base_url + backdrop_path
        val img = imageBaseUrl + movieImg
        //imageView
        val imgHolder = holder.itemView.img_itemHolder
        Glide.with(holder.itemView.context).load(img).into(imgHolder)

        holder.itemView.movie_name.text = currentItem.name
        holder.itemView.vote_average.text = currentItem.voteAverage.toString()

        holder.similarMovieDetail(currentItem)

    }

    override fun getItemCount() = similarList.size

    fun setSimilarMovieData(newList: List<MovieData>) {
        similarList = newList as ArrayList<MovieData>
        notifyDataSetChanged()
    }

    private var listenerSimilarDetailScreen: SimilarDetailScreen? = null

    interface SimilarDetailScreen {
        fun similarDetailScreen(movie: MovieData)
    }

    fun editSimilarMovieItem(listener: SimilarDetailScreen) {
        this.listenerSimilarDetailScreen = listener
    }

}