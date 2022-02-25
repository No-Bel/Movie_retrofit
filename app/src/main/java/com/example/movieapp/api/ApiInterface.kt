package com.example.movieapp.api


import com.example.movieapp.moviedata.Movies
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


//https://api.themoviedb.org/3/tv/popular?api_key=15ee041769410c69401e811ad54cff8f&page
interface ApiInterface {

    @GET("3/tv/popular")
    suspend fun getMovie(
        @Query("api_key") api: String
    ): Response<Movies>

}
