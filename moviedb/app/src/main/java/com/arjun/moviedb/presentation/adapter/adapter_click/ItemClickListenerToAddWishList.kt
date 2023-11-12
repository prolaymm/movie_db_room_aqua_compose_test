package com.arjun.moviedb.presentation.adapter.adapter_click

import com.arjun.moviedb.domain.vos.MovieWishlistVo
import com.arjun.moviedb.domain.vos.PopularMovieVo

interface ItemClickListenerToAddWishList {
    fun onAddToFavorite(vo : PopularMovieVo)



}

interface  ItemClickListenerToRemoveWishlist {
    fun onRemoveWishlist(vo : MovieWishlistVo)


}