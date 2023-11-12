package com.arjun.moviedb.domain.repository.impl

import ApiResponse
import android.util.Log
import com.arjun.moviedb.domain.repository.MovieRepo
import com.arjun.moviedb.domain.vos.MovieResultVo
import com.arjun.moviedb.domain.vos.MovieWishlistVo
import com.arjun.moviedb.domain.vos.PopularMovieVo
import com.arjun.moviedb.services.api_service.ApiClient
import com.arjun.moviedb.services.db_service.WishlistDao
import com.arjun.moviedb.utils.ApiConstant
import com.example.myapplication.services.DBService.MovieDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response
import javax.inject.Inject

class MovieRepoImpl @Inject constructor(private  val apiClient: ApiClient, private val movieDao: MovieDao,private val wishlistDao: WishlistDao) : MovieRepo {



    override suspend fun getPopularMovie( token : String): Flow<Response<MovieResultVo>> =  flow {
        emit(apiClient.getPopularMovie(token))
    }.flowOn(Dispatchers.IO)

    override suspend fun getMovieFromRoom(): Flow<List<PopularMovieVo>>  = movieDao.getAllMovie().flowOn(Dispatchers.IO)
    override  fun saveMovieToRoom(popularMovieVo: PopularMovieVo) {
        movieDao.addMovie(popularMovieVo)
    }

    override   suspend fun getMovieFromWishlist() : Flow<List<MovieWishlistVo>> = wishlistDao.getAllWishlist().flowOn(Dispatchers.IO)

    override fun saveToWishlist(movieWishlistVo: MovieWishlistVo) {

        wishlistDao.addToWishlist(movieWishlistVo)
    }

    override fun deleteFromWishlist(movieWishlistVo: MovieWishlistVo) {
        wishlistDao.deleteFromWishlist(movieWishlistVo)
    }


}