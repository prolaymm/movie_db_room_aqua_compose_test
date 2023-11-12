package com.arjun.moviedb.domain.vos

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.arjun.moviedb.utils.DatabaseConstant
import com.google.gson.annotations.SerializedName

@Entity(tableName = DatabaseConstant.MOVIE_TABLE)
data class  PopularMovieVo (


    @ColumnInfo("adult")
    @SerializedName("adult")
    val adult: Boolean,

    @ColumnInfo("backdrop_path")
    @SerializedName("backdrop_path")
    val backdropPath: String,

   // @ColumnInfo("genre_ids")
/*    @SerializedName("genre_ids")
    val genreids: List<Long>,*/

    @PrimaryKey(autoGenerate = false)
    @SerializedName("id")
    val id: Long,

    @ColumnInfo("original_language")
    @SerializedName("original_language")
    val originalLanguage: String,

    @ColumnInfo("original_title")
    @SerializedName("original_title")
    val originalTitle: String,

    @ColumnInfo("overview")
    @SerializedName("overview")
    val overview: String,

    @ColumnInfo("popularity")
    @SerializedName("popularity")
    val popularity: Double,


    @ColumnInfo("poster_path")
    @SerializedName("poster_path")
    val posterPath: String,

    @ColumnInfo("release_date")
    @SerializedName("release_date")
    val releaseDate: String,

    @ColumnInfo("title")
    @SerializedName("title")
    val title: String,

    @ColumnInfo("video")
    @SerializedName("video")
    val video: Boolean,

    @ColumnInfo("vote_average")
    @SerializedName("vote_average")
    val voteAverage: Double? = 0.0,

    @ColumnInfo("vote_count")
    @SerializedName("vote_count")
    val voteCount: Long
)