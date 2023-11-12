package com.arjun.moviedb.viewmodel

import ApiResponse
import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arjun.moviedb.domain.repository.impl.MovieRepoImpl
import com.arjun.moviedb.domain.vos.MovieWishlistVo
import com.arjun.moviedb.domain.vos.PopularMovieVo
import com.arjun.moviedb.utils.ApiConstant
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class MovieViewModel  @Inject constructor(private  val movieRepoImpl: MovieRepoImpl) : ViewModel(){
    val movieResult  = MutableStateFlow<ApiResponse<List<PopularMovieVo>>>(ApiResponse.Loading())

    init {
        getAllMovie()
        getAllMovieFromRoom()
    }

     @SuppressLint("SuspiciousIndentation")
     fun getAllMovie() {
        viewModelScope.launch(Dispatchers.IO) {
            movieResult.value = ApiResponse.Loading()
                movieRepoImpl.getPopularMovie(ApiConstant.API_READ_ACCESS_TOKEN).catch {
                    Log.d("MOVIEDATA","${it.message}");
                    movieResult.value = ApiResponse.Error(message = it.message?:"Somethig gone wring")
                }.collect{
                    //      Log.d("MOVIEDATA","${it.message()}");
                    if(it.isSuccessful) {
                        val list : List<PopularMovieVo>? = it.body()?.movieList
                        list.let {myList ->
                            for (vo : PopularMovieVo in myList!!){
                                saveToRoom(vo)
                            }

                        }
                        movieResult.value = ApiResponse.Success(data = it.body()?.movieList?: emptyList())
                    } else {
                        movieResult.value = ApiResponse.Error(message = it.message()?:"Somethig gone wring")
                    }

                }
            }
        }


     fun getAllMovieFromRoom() {
        viewModelScope.launch(Dispatchers.IO) {
            movieRepoImpl.getMovieFromRoom().catch {
                Log.d("DATABASE","${it.message}");
            }.collect{
                movieResult.value = ApiResponse.Success(data = it)
            }
        }
    }


    private fun saveToRoom(movieVo: PopularMovieVo){

        movieRepoImpl.saveMovieToRoom(movieVo)
    }

    fun makeWishlist(vo: PopularMovieVo) {
       viewModelScope.launch(Dispatchers.IO) {
           movieRepoImpl.saveToWishlist(MovieWishlistVo(title = vo.title, id = vo.id, image = vo.posterPath))
       }
    }
}