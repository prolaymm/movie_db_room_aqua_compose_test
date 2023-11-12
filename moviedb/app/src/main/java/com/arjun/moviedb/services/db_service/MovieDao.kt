package com.example.myapplication.services.DBService

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.arjun.moviedb.domain.vos.PopularMovieVo
import com.arjun.moviedb.utils.DatabaseConstant
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addMovie( popularMovieVo: PopularMovieVo)


    @Query("select * from movie")
      fun getAllMovie() : Flow<List<PopularMovieVo>>
}