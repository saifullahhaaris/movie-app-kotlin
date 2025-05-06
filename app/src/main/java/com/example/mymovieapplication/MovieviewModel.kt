package com.example.mymovieapplication.ui

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mymovieapplication.data.MovieEntity
import com.example.mymovieapplication.data.MovieRepository
import com.example.mymovieapplication.data.api.OmdbApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val repository: MovieRepository,
    private val apiService: OmdbApiService
) : ViewModel() {

    private val _uiState = MutableStateFlow<UiState>(UiState.Idle)
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    private val _actorSearchResults = MutableStateFlow<List<MovieEntity>>(emptyList())
    val actorSearchResults: StateFlow<List<MovieEntity>> = _actorSearchResults.asStateFlow()

    private val _webSearchResults = MutableStateFlow<List<MovieEntity>>(emptyList())
    val webSearchResults: StateFlow<List<MovieEntity>> = _webSearchResults.asStateFlow()

    val snackbarHostState = SnackbarHostState()

    fun insertMovie(movie: MovieEntity) {
        viewModelScope.launch {
            try {
                if (movie.title != null) {
                    val existingMovies = repository.searchMovies(movie.title).first()
                    if (existingMovies.none { it.imdbID == movie.imdbID }) {
                        repository.insertMovie(movie)
                        _uiState.value = UiState.Success("Movie added successfully!")
                    } else {
                        _uiState.value = UiState.Success("Movie already exists in database.")
                    }
                } else {
                    _uiState.value = UiState.Error("Cannot add movie with no title.")
                }
            } catch (e: Exception) {
                _uiState.value = UiState.Error("Failed to add movie: ${e.message}")
            }
        }
    }

    fun searchMovie(title: String) {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            try {
                val movie = apiService.searchMovie(title)
                _uiState.value = UiState.Success(movie)
            } catch (e: Exception) {
                _uiState.value = UiState.Error("Failed to search movie: ${e.message}")
            }
        }
    }

    fun searchActors(query: String) {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            try {
                repository.searchActors(query).collect { movies ->
                    _actorSearchResults.value = movies
                }
                _uiState.value = UiState.Success("Actor search complete")
            } catch (e: Exception) {
                _uiState.value = UiState.Error("Failed to search actors")
            }
        }
    }

    fun searchWebMovies(query: String) {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            try {
                val response = apiService.searchMoviesByTitle(query)
                _webSearchResults.value = response.movies ?: emptyList()
                _uiState.value = UiState.Success("Web search complete")
            } catch (e: Exception) {
                _uiState.value = UiState.Error("Failed to search web")
            }
        }
    }

    fun resetUiState() {
        _uiState.value = UiState.Idle
    }

    sealed class UiState {
        object Idle : UiState()
        object Loading : UiState()
        data class Success(val data: Any) : UiState()
        data class Error(val message: String) : UiState()
    }
}


//// API operations
//fun searchMovie(title: String) = viewModelScope.launch {
//    _searchedMovie.value = apiService.searchMovie(title)
//}
//
////fun searchActors(query: String) = repository.searchActors(query)
