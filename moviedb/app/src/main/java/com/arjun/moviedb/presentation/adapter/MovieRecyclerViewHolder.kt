package com.arjun.moviedb.presentation.adapter

import android.content.Context
import android.provider.SyncStateContract.Constants
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.arjun.moviedb.R
import com.arjun.moviedb.databinding.ActivityMainBinding
import com.arjun.moviedb.databinding.MovieCardBinding
import com.arjun.moviedb.domain.vos.PopularMovieVo
import com.arjun.moviedb.utils.ApiConstant
import com.bumptech.glide.Glide


class MovieRecyclerViewHolder(private  val movieBinding: MovieCardBinding) : RecyclerView.ViewHolder(movieBinding.root) {


        val binding = movieBinding

   fun onItemBind(item : PopularMovieVo,context: Context ){
        Glide
         .with(context)
         .load("https://image.tmdb.org/t/p/original/${item.posterPath}")
         .centerCrop()
         .placeholder(R.drawable.movie)
         .into(movieBinding.movieImageView);
      movieBinding.movieName.text = item.title
   }




}