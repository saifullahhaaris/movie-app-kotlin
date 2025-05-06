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
fun SearchActorScreen(viewModel: MovieViewModel = hiltViewModel()) {
    var actorQuery by remember { mutableStateOf("") }
    val searchResults by viewModel.actorSearchResults.collectAsState(initial = emptyList())
    val snackbarHostState = remember { SnackbarHostState() }

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues).padding(16.dp)) {
            TextField(
                value = actorQuery,
                onValueChange = { actorQuery = it },
                label = { Text("Search Actor") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(Modifier.height(8.dp))

            GradientButton(
                onClick = { viewModel.searchActors(actorQuery) },
                text = "Search",
                gradientColors = listOf(Color.Blue, Color(0xFF64B5F6)),
                contentColor = Color.White,
                modifier = Modifier.fillMaxWidth()
            )


            LazyColumn {
                items(searchResults) { movie: MovieEntity ->
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