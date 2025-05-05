package com.example.mymovieapplication.data

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(
    onAddMoviesClick: () -> Unit,
    onSearchMovieClick: () -> Unit,
    onSearchActorClick: () -> Unit,
    onWebSearchClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = onAddMoviesClick,
            modifier = Modifier.fillMaxWidth(0.8f)
        ) {
            Text("Add Movies to DB")
        }
        Button(
            onClick = onSearchMovieClick,
            modifier = Modifier.fillMaxWidth(0.8f)
        ) {
            Text("Search for Movies")
        }
        Button(
            onClick = onSearchActorClick,
            modifier = Modifier.fillMaxWidth(0.8f)
        ) {
            Text("Search for Actors")
        }
        Button(
            onClick = onWebSearchClick,
            modifier = Modifier.fillMaxWidth(0.8f)
        ) {
            Text("Web Search")
        }
    }
}