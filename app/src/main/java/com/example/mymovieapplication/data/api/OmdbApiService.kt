// https://www.omdbapi.com/?t=Matrix&apikey=YOUR_OWN_API_KEY


package com.example.mymovieapplication.data.api

import com.example.mymovieapplication.data.MovieEntity
import retrofit2.http.GET
import retrofit2.http.Query

interface OmdbApiService {
    @GET("/")
    suspend fun searchMovie(
        @Query("t") title: String,
        @Query("apikey") apiKey: String = "YOUR_OWN_API_KEY"
    ): MovieEntity

    @GET("/")
    suspend fun searchMoviesByTitle(
        @Query("s") query: String,
        @Query("apikey") apiKey: String = "YOUR_OWN_API_KEY"
    ): SearchResponse
}
