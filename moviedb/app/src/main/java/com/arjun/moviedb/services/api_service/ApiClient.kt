package com.arjun.moviedb.services.api_service

import com.arjun.moviedb.domain.vos.MovieResultVo
import com.arjun.moviedb.utils.ApiConstant
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface ApiClient {


    @GET(ApiConstant.popularMovie)
    suspend fun getPopularMovie(@Header("Authorization") token : String) :  Response<MovieResultVo>
}