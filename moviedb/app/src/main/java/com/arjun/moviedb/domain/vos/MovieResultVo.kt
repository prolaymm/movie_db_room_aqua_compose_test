package com.arjun.moviedb.domain.vos
import com.google.gson.annotations.SerializedName


data class MovieResultVo (
    @SerializedName("page")
    val page: Long,
    @SerializedName("results")
    val movieList: List<PopularMovieVo>,

    @SerializedName("total_pages")
    val totalPages: Long,

    @SerializedName("total_results")
    val totalResults: Long
)


