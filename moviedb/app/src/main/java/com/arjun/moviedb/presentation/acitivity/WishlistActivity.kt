package com.arjun.moviedb.presentation.acitivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.arjun.moviedb.databinding.ActivityWishlistBinding
import com.arjun.moviedb.domain.vos.MovieWishlistVo
import com.arjun.moviedb.domain.vos.PopularMovieVo
import com.arjun.moviedb.presentation.adapter.WishlistMovieRecyclerAdapter
import com.arjun.moviedb.presentation.adapter.adapter_click.ItemClickListenerToAddWishList
import com.arjun.moviedb.presentation.adapter.adapter_click.ItemClickListenerToRemoveWishlist
import com.arjun.moviedb.viewmodel.WishListViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class WishlistActivity : AppCompatActivity(),ItemClickListenerToRemoveWishlist {



   private lateinit var  wishlistBinding : ActivityWishlistBinding
   lateinit var  wishlistRecyclerView : RecyclerView

    private val wishlistViewModel: WishListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        wishlistBinding = ActivityWishlistBinding.inflate(layoutInflater)
        setContentView(wishlistBinding.root)
        wishlistRecyclerView = wishlistBinding.wishlistRecyclerView
        val  adapter  : WishlistMovieRecyclerAdapter =  WishlistMovieRecyclerAdapter(this)

        wishlistRecyclerView.layoutManager = LinearLayoutManager(this)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        wishlistRecyclerView.adapter = adapter

        lifecycleScope.launch(Dispatchers.Main) {
            wishlistViewModel.movieResult.collect {
                 adapter.setMovies(it)
                wishlistBinding.empytWishlistText.isVisible = it.isEmpty()
            }
        }
    }



    override fun onRemoveWishlist(vo: MovieWishlistVo) {

        wishlistViewModel.deleteFromWishlist(vo)
    }
}