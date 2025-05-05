package com.example.mymovieapplication.data.api

import com.example.mymovieapplication.data.MovieEntity
import com.google.gson.annotations.SerializedName

data class SearchResponse(
    @SerializedName("Search") val movies: List<MovieEntity>?,
    val totalResults: String,
    val Response: String
)