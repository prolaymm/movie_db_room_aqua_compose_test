package com.arjun.moviedb.services.api_service

import com.arjun.moviedb.utils.ApiConstant
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApiService {

    @Provides
    @Singleton
    fun provideBaseUrl() = ApiConstant.BASE_URl

    @Provides
    @Singleton
    fun provideRetrofit(baseUrl : String) : Retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()


    @Provides
    @Singleton
    fun providePostApi(retrofit: Retrofit) : ApiClient {
        return retrofit.create(ApiClient::class.java)
    }
}