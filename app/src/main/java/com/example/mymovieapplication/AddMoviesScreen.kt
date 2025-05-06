package com.example.movieapp.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.mymovieapplication.data.MovieData
import com.example.mymovieapplication.data.MovieEntity
import com.example.mymovieapplication.ui.MovieViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import com.example.mymovieapplication.ui.theme.GradientButton


@Composable
fun AddMoviesScreen(
    viewModel: MovieViewModel = hiltViewModel()
) {
    val movies = MovieData.hardcodedMovies
    val uiState by viewModel.uiState.collectAsState()

    LaunchedEffect(uiState) {
        if (uiState is MovieViewModel.UiState.Success) {
            val message = (uiState as MovieViewModel.UiState.Success).data.toString()
            println("Success: $message")
            viewModel.resetUiState()
        } else if (uiState is MovieViewModel.UiState.Error) {
            val message = (uiState as MovieViewModel.UiState.Error).message
            println("Error: $message")
            viewModel.resetUiState()
        }
    }

    Scaffold(
        snackbarHost = { SnackbarHost(viewModel.snackbarHostState) }
    ) { paddingValues ->
        LazyColumn(contentPadding = paddingValues) {
            items(movies) { movie ->
                MovieItem(
                    movie = movie,
                    onAddClick = { viewModel.insertMovie(movie) },
                    snackbarHostState = viewModel.snackbarHostState
                )
            }
        }
    }
}

@Composable
fun MovieItem(
    movie: MovieEntity,
    onAddClick: () -> Unit,
    snackbarHostState: SnackbarHostState
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(movie.title ?: "No Title", style = MaterialTheme.typography.titleLarge)
            Text("${movie.year} • ${movie.runtime}", style = MaterialTheme.typography.bodyMedium)
            Spacer(Modifier.height(8.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                GradientButton(
                    onClick = {
                        onAddClick()
                        CoroutineScope(Dispatchers.Main).launch {
                            snackbarHostState.showSnackbar(
                                message = "Adding '${movie.title}' to database...",
                                duration = SnackbarDuration.Short
                            )
                        }
                    },
                    text = "Add to Database",
                    gradientColors = listOf(Color.Blue, Color(0xFF64B5F6)), // 0xFF64B5F6
                    contentColor = Color.Black
                )
            }
        }
    }
}
