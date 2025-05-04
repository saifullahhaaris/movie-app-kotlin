package com.example.movieapp.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.mymovieapplication.data.MovieData
import com.example.mymovieapplication.data.MovieEntity
import com.example.mymovieapplication.ui.MovieViewModel


@Composable
fun AddMoviesScreen(
    viewModel: MovieViewModel = hiltViewModel()
) {
    val movies = MovieData.hardcodedMovies

    LazyColumn {
        items(movies) { movie ->
            MovieItem(
                movie = movie,
                onAddClick = { viewModel.insertMovie(movie) }
            )
        }
    }
}

@Composable
fun MovieItem(movie: MovieEntity, onAddClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(movie.title, style = MaterialTheme.typography.titleLarge)
            Text("${movie.year} • ${movie.runtime}", style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                onClick = onAddClick,
                modifier = Modifier.align(Alignment.End)
            ) {
                Text("Add to Database")
            }
        }
    }
}