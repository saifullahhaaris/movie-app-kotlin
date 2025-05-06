package com.example.mymovieapplication.ui

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.mymovieapplication.data.MovieEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import androidx.compose.ui.graphics.Color
import com.example.mymovieapplication.ui.theme.GradientButton


@Composable
fun SearchMovieScreen(viewModel: MovieViewModel = hiltViewModel()) {
    var movieTitle by remember { mutableStateOf("") }
    val uiState by viewModel.uiState.collectAsState()
    val snackbarHostState = remember { SnackbarHostState() }

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .background(Color.Black)
                .padding(16.dp)
        ) {
            TextField(
                value = movieTitle,
                onValueChange = { movieTitle = it },
                label = { Text("Movie Title", color = Color.White) },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.colors(
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White,
                    cursorColor = Color.White,
                    focusedIndicatorColor = Color.White,
                    unfocusedIndicatorColor = Color.Gray,
                    focusedLabelColor = Color.White,
                    unfocusedLabelColor = Color.Gray

                )
            )

            Spacer(Modifier.height(16.dp))

            GradientButton(
                onClick = {
                    Log.d("SearchMovieScreen", "Search button clicked for title: $movieTitle")
                    viewModel.searchMovie(movieTitle)
                },
                text = "Retrieve Movie",
                gradientColors = listOf(Color.Blue, Color(0xFF64B5F6)),
                contentColor = Color.White,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(Modifier.height(16.dp))

            when (val state = uiState) {
                is MovieViewModel.UiState.Success -> {
                    val movie = state.data as? MovieEntity
                    if (movie != null) {
                        Log.d("SearchMovieScreen", "Movie retrieved successfully: $movie")
                        Column(modifier = Modifier.background(Color.Black)) {
                            Text("TITLE:- ${movie.title}", color = Color.White)
                            Text("YEAR:- ${movie.year}", color = Color.White)
                            Text("RATED:- ${movie.rated}", color = Color.White)
                            Text("RELEASED:- ${movie.released}", color = Color.White)
                            Text("RUNTIME:- ${movie.runtime}", color = Color.White)
                            Text("GENRE:- ${movie.genre}", color = Color.White)
                            Text("DIRECTOR:- ${movie.director}", color = Color.White)
                            Text("WRITER:- ${movie.writer}", color = Color.White)
                            Text("ACTORS:- ${movie.actors}", color = Color.White)
                            Text("PLOT:- ${movie.plot}", color = Color.White)
                        }
                        Spacer(Modifier.height(8.dp))
                        GradientButton(
                            onClick = {
                                viewModel.insertMovie(movie)
                                CoroutineScope(Dispatchers.Main).launch {
                                    snackbarHostState.showSnackbar(
                                        message = "'${movie.title}' saved to database",
                                        duration = SnackbarDuration.Short
                                    )
                                }
                            },
                            text = "Save movie to Database",
                            gradientColors = listOf(Color.Green, Color(0xFF64B5F6)), //green to blue gradient
                            contentColor = Color.Black,
                            modifier = Modifier.fillMaxWidth()
                        )
                    } else {
                        Log.e("SearchMovieScreen", "Retrieved data is not a MovieEntity")
                        Text("Error: Could not display movie details.", color = Color.Red)
                    }
                }
                is MovieViewModel.UiState.Error -> {
                    val errorMessage = state.message
                    Log.e("SearchMovieScreen", "Error retrieving movie: $errorMessage")
                    Text("Error: $errorMessage", color = MaterialTheme.colorScheme.error)
                    LaunchedEffect(errorMessage) {
                        snackbarHostState.showSnackbar(
                            message = "Error: $errorMessage",
                            duration = SnackbarDuration.Long
                        )
                    }
                }
                MovieViewModel.UiState.Loading -> {
                    Log.d("SearchMovieScreen", "Loading movie details...")
                    CircularProgressIndicator(color = Color.White)
                }
                else -> {
                }
            }
        }
    }
}