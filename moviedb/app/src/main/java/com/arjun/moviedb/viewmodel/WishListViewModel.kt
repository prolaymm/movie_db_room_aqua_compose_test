package com.arjun.moviedb.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arjun.moviedb.domain.repository.impl.MovieRepoImpl
import com.arjun.moviedb.domain.vos.MovieWishlistVo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WishListViewModel @Inject constructor(private  val movieRepoImpl: MovieRepoImpl) : ViewModel() {

    val movieResult  = MutableStateFlow<List<MovieWishlistVo>>(arrayListOf())

    init {
       getAllWishList()

    }

    private fun  getAllWishList() {
       viewModelScope.launch(Dispatchers.IO) {
           movieRepoImpl.getMovieFromWishlist().catch {
               Log.d("MOVIE_DATA","ERROR ${it.message}")
           }.collect{
             if(it.isNotEmpty()){
                 movieResult.value = it
             }
           }
       }

    }


      fun deleteFromWishlist(vo :  MovieWishlistVo) {
      viewModelScope.launch(Dispatchers.IO) {
          movieRepoImpl.deleteFromWishlist(vo)
      }
    }
}