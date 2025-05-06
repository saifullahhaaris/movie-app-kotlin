package com.example.mymovieapplication.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE) // toPrevent duplicate key errors
    suspend fun insertMovie(movie: MovieEntity)

    @Query("SELECT * FROM movies WHERE actors LIKE '%' || :query || '%' COLLATE NOCASE")
    fun searchActors(query: String): Flow<List<MovieEntity>>

    @Query("SELECT * FROM movies WHERE title LIKE '%' || :query || '%' COLLATE NOCASE")
    fun searchMovies(query: String): Flow<List<MovieEntity>>

    @Query("SELECT * FROM movies")
    fun getAllMovies(): Flow<List<MovieEntity>>
}