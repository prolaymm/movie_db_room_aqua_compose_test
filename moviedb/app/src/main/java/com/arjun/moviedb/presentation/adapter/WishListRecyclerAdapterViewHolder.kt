package com.arjun.moviedb.presentation.adapter

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.arjun.moviedb.R
import com.arjun.moviedb.databinding.WishListCardBinding
import com.arjun.moviedb.domain.vos.MovieWishlistVo
import com.arjun.moviedb.domain.vos.PopularMovieVo
import com.bumptech.glide.Glide

class WishListRecyclerAdapterViewHolder(private  val wishListCardBinding: WishListCardBinding) : RecyclerView.ViewHolder(wishListCardBinding.root) {

    val binding= wishListCardBinding

    fun onItemBind(item : MovieWishlistVo, context: Context){
        Glide
            .with(context)
            .load("https://image.tmdb.org/t/p/original/${item.image}")
            .centerCrop()
            .placeholder(R.drawable.movie)
            .into(wishListCardBinding.wishlistImage);
        wishListCardBinding.wishlistText.text = item.title
    }




}