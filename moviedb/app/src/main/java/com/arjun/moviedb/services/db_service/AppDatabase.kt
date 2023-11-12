package com.example.myapplication.services.DBService

import androidx.room.Database
import androidx.room.RoomDatabase
import com.arjun.moviedb.domain.vos.MovieWishlistVo
import com.arjun.moviedb.domain.vos.PopularMovieVo
import com.arjun.moviedb.services.db_service.WishlistDao

@Database(version = 2, entities = [PopularMovieVo::class,MovieWishlistVo::class], exportSchema = true)
abstract class AppDatabase : RoomDatabase() {

    abstract  fun movieDao() : MovieDao
    abstract  fun wishlistDao() : WishlistDao
}