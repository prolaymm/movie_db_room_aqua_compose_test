package com.arjun.moviedb.presentation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.arjun.moviedb.databinding.MovieCardBinding
import com.arjun.moviedb.domain.vos.PopularMovieVo
import com.arjun.moviedb.presentation.adapter.adapter_click.ItemClickListenerToAddWishList

class MovieRecyclerAdapter(private  val itemClickListener: ItemClickListenerToAddWishList) : RecyclerView.Adapter<MovieRecyclerViewHolder>() {

    private lateinit var  context : Context
    private var mMovieList: MutableList<PopularMovieVo> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieRecyclerViewHolder {

        context = parent.context
        val binding = MovieCardBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieRecyclerViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return  mMovieList.size
    }

    override fun onBindViewHolder(holder: MovieRecyclerViewHolder, position: Int) {
        holder.onItemBind(mMovieList[position],context)

        holder.binding.homeWishListButton.setOnClickListener{
            itemClickListener.onAddToFavorite(mMovieList[position])
            Toast.makeText(context,"Success",Toast.LENGTH_SHORT).show()
        }
    }
    fun setMovies(movies : List<PopularMovieVo>) {
        mMovieList = movies as ArrayList<PopularMovieVo>
        notifyDataSetChanged()

    }
}

