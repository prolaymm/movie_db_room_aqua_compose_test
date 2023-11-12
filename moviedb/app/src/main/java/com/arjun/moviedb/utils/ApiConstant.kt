package com.arjun.moviedb.utils

object ApiConstant {

    const  val API_READ_ACCESS_TOKEN: String = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI4NDcyOGQxNmMyMjhhNTliMTJiNGIwYWVhNTM2ZDBiNSIsInN1YiI6IjY1NGY3MTk0ZDRmZTA0MDBmZTAzMjFlNCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.JPw1RyE5JEf-ch4jdyhdfIiQtdI4DS7HVu3BuFAqzf0";
    const val  API_TOKEN : String = "84728d16c228a59b12b4b0aea536d0b5"
    const val  BASE_URl : String = "https://api.themoviedb.org/"

    ///api end points
    const val  popularMovie : String = "3/discover/movie?include_adult=false&include_video=false&language=en-US&page=1&sort_by=popularity.desc"



}