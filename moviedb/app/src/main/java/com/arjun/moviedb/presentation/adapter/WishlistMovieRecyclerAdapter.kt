package com.arjun.moviedb.presentation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.arjun.moviedb.databinding.WishListCardBinding
import com.arjun.moviedb.domain.vos.MovieWishlistVo
import com.arjun.moviedb.domain.vos.PopularMovieVo
import com.arjun.moviedb.presentation.adapter.adapter_click.ItemClickListenerToRemoveWishlist

class WishlistMovieRecyclerAdapter(private val  itemClickListenerToRemoveWishlist: ItemClickListenerToRemoveWishlist)  : RecyclerView.Adapter<WishListRecyclerAdapterViewHolder>() {

    private lateinit var  context : Context
    private var mMovieList: MutableList<MovieWishlistVo> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WishListRecyclerAdapterViewHolder {

        context = parent.context
        val binding = WishListCardBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return WishListRecyclerAdapterViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return  mMovieList.size
    }

    override fun onBindViewHolder(holder: WishListRecyclerAdapterViewHolder, position: Int) {
        holder.onItemBind(mMovieList[position],context)
        holder.binding.wishListButton.setOnClickListener{

            itemClickListenerToRemoveWishlist.onRemoveWishlist(mMovieList[position])


        }


    }
    fun setMovies(movies : List<MovieWishlistVo>) {
        mMovieList = movies as ArrayList<MovieWishlistVo>
        notifyDataSetChanged()

    }
}