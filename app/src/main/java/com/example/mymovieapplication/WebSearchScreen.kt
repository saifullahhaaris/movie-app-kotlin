package com.example.mymovieapplication.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.movieapp.ui.MovieItem
import com.example.mymovieapplication.data.MovieEntity
import com.example.mymovieapplication.ui.theme.GradientButton
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun WebSearchScreen(viewModel: MovieViewModel = hiltViewModel()) {
    var query by remember { mutableStateOf("") }
    val searchResults by viewModel.webSearchResults.collectAsState()
    val snackbarHostState = remember { SnackbarHostState() }

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues).padding(16.dp)) {
            TextField(
                value = query,
                onValueChange = { query = it },
                label = { Text("Search Title") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(Modifier.height(8.dp))

            GradientButton(
                onClick = { viewModel.searchWebMovies(query) },
                text = "Search Web",
                gradientColors = listOf(Color.Blue, Color(0xFF64B5F6)),
                contentColor = Color.White,
                modifier = Modifier.fillMaxWidth()
            )

            LazyColumn {
                items(searchResults, key = { it.imdbID }) { movie: MovieEntity ->
                    MovieItem(
                        movie = movie,
                        onAddClick = {
                            viewModel.insertMovie(movie)
                            CoroutineScope(Dispatchers.Main).launch {
                                snackbarHostState.showSnackbar(
                                    message = "Adding '${movie.title}' to database...",
                                    duration = SnackbarDuration.Short
                                )
                            }
                        },
                        snackbarHostState = snackbarHostState
                    )
                }
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
            GradientButton(
                onClick = onAddClick,
                text = "Add to Database",
                gradientColors = listOf(Color.Green, Color(0xFF81C784)),
                contentColor = Color.White
            )
        }
    }
}