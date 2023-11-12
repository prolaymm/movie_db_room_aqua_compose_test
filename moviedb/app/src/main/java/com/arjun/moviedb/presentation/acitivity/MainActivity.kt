package com.arjun.moviedb.presentation.acitivity

import ApiResponse
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.arjun.moviedb.databinding.ActivityMainBinding
import com.arjun.moviedb.domain.vos.PopularMovieVo
import com.arjun.moviedb.presentation.adapter.MovieRecyclerAdapter
import com.arjun.moviedb.presentation.adapter.adapter_click.ItemClickListenerToAddWishList
import com.arjun.moviedb.viewmodel.MovieViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity(),ItemClickListenerToAddWishList {

    lateinit var   mainBinding : ActivityMainBinding

    lateinit var  movieReclerView : RecyclerView
    val movieViewModel : MovieViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        movieReclerView = mainBinding.homeMovieRecylerView
        val  adapter  : MovieRecyclerAdapter=  MovieRecyclerAdapter(this)

        movieReclerView.layoutManager = LinearLayoutManager(this)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        movieReclerView.adapter = adapter

        mainBinding.homeFloatingActionButton.setOnClickListener{

            startActivity(Intent(this,WishlistActivity::class.java))
        }
        mainBinding.homeRetryButton.setOnClickListener{
            movieViewModel.getAllMovie()
            movieViewModel.getAllMovieFromRoom()
        }

        lifecycleScope.launch(Dispatchers.Main) {
            movieViewModel.movieResult.collect{
                //mainBinding.simpleTexyt.text = "${it}"
                Log.d("ARJUNERROR","$it")
                when(it) {
                    is ApiResponse.Loading ->  {
                        mainBinding.homeProgress.isVisible = true
                    }
                    is ApiResponse.Success -> {
                        mainBinding.homeProgress.isVisible = false
                        if(it.data.isEmpty()){
                            showErrorLoading(isLoading = false, isApiError = true,"No Data Found")
                        }
                        adapter.setMovies(it.data)
                    }

                    else -> {
                        mainBinding.homeProgress.isVisible = true

                    }
                }
            }

        }

    }

    private  fun showErrorLoading( isLoading : Boolean,isApiError : Boolean,title : String?=""){

        if(isLoading){
            mainBinding.homeProgress.isVisible = true
            mainBinding.homeErrorText.text = "Loading"
            mainBinding.homeRetryButton.isVisible = false
        }
       else  if(isApiError) {
            mainBinding.homeProgress.isVisible = false
            mainBinding.homeErrorText.isVisible = true
            mainBinding.homeRetryButton.isVisible = true
            mainBinding.homeErrorText.text = title

        } else {
            mainBinding.homeProgress.isVisible = false
            mainBinding.homeErrorText.isVisible = false
            mainBinding.homeRetryButton.isVisible = false
        }

    }

    override fun onAddToFavorite(vo : PopularMovieVo) {

        movieViewModel.makeWishlist(vo)
    }
}