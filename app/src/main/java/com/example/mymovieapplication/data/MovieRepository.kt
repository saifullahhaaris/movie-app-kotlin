package com.example.mymovieapplication.data

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MovieRepository @Inject constructor(private val movieDao: MovieDao) {
    val allMovies: Flow<List<MovieEntity>> = movieDao.getAllMovies()

    suspend fun insertMovie(movie: MovieEntity) = movieDao.insertMovie(movie)

    fun searchActors(query: String): Flow<List<MovieEntity>> =
        movieDao.searchActors(query)

    fun searchMovies(query: String): Flow<List<MovieEntity>> =
        movieDao.searchMovies(query)
}