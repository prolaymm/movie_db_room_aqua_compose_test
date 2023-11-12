package com.arjun.moviedb.services.db_service

import androidx.room.Dao
import androidx.room.Database
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.arjun.moviedb.domain.vos.MovieWishlistVo
import com.arjun.moviedb.domain.vos.PopularMovieVo
import com.arjun.moviedb.utils.DatabaseConstant
import kotlinx.coroutines.flow.Flow

@Dao
interface WishlistDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addToWishlist( postVo: MovieWishlistVo)

    @Delete
    fun deleteFromWishlist( postVo: MovieWishlistVo)
    @Query("select * from wishlist")
    fun getAllWishlist() : Flow<List<MovieWishlistVo>>
}