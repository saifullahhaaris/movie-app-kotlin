package com.example.mymovieapplication.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName



@Entity(tableName = "movies")
data class MovieEntity(
    @PrimaryKey
    @SerializedName("imdbID")
    val imdbID: String,
    @SerializedName("Title")
    val title: String?,
    @SerializedName("Year")
    val year: String?,
    @SerializedName("Rated")
    val rated: String?,
    @SerializedName("Released")
    val released: String?,
    @SerializedName("Runtime")
    val runtime: String?,
    @SerializedName("Genre")
    val genre: String?,
    @SerializedName("Director")
    val director: String?,
    @SerializedName("Writer")
    val writer: String?,
    @SerializedName("Actors")
    val actors: String?,
    @SerializedName("Plot")
    val plot: String?,
    @SerializedName("Language")
    val language: String?,
    @SerializedName("Country")
    val country: String?,
    @SerializedName("Awards")
    val awards: String?,
    @SerializedName("imdbRating")
    val imdbRating: String?,
    @SerializedName("Type")
    val type: String?
)