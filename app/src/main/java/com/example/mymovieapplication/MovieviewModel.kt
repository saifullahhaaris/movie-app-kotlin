package com.example.mymovieapplication.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mymovieapplication.data.MovieEntity
import com.example.mymovieapplication.data.MovieRepository
import com.example.mymovieapplication.data.api.OmdbApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val repository: MovieRepository,
    private val apiService: OmdbApiService
) : ViewModel() {

    private val _searchedMovie = MutableStateFlow<MovieEntity?>(null)
    val searchedMovie = _searchedMovie.asStateFlow()

    // Database operations
    fun insertMovie(movie: MovieEntity) = viewModelScope.launch {
        repository.insertMovie(movie)
    }

    // API operations
    fun searchMovie(title: String) = viewModelScope.launch {
        _searchedMovie.value = apiService.searchMovie(title)
    }

    //fun searchActors(query: String) = repository.searchActors(query)
}