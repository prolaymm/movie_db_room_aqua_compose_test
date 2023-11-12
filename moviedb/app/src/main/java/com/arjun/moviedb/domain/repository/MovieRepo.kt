package com.arjun.moviedb.domain.repository

import ApiResponse
import com.arjun.moviedb.domain.vos.MovieResultVo
import com.arjun.moviedb.domain.vos.MovieWishlistVo
import com.arjun.moviedb.domain.vos.PopularMovieVo
import kotlinx.coroutines.flow.Flow
import retrofit2.Response


interface  MovieRepo {

     suspend fun getPopularMovie( token : String) : Flow<Response<MovieResultVo>>

     suspend fun getMovieFromRoom() : Flow<List<PopularMovieVo>>

     fun  saveMovieToRoom(popularMovieVo: PopularMovieVo)


     suspend fun getMovieFromWishlist() : Flow<List<MovieWishlistVo>>

     fun  saveToWishlist(movieWishlistVo: MovieWishlistVo)
     fun  deleteFromWishlist(movieWishlistVo: MovieWishlistVo)

}