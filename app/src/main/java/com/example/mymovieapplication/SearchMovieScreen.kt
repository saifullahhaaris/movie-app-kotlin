package com.example.mymovieapplication.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SearchMovieScreen() {
    var movieTitle by remember { mutableStateOf("") }
    var movieInfo by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        TextField(
            value = movieTitle,
            onValueChange = { movieTitle = it },
            label = { Text("Movie Title") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = {
            // Call OMDb API and update movieInfo
            movieInfo = "Retrieved info for: $movieTitle"
        }) {
            Text("Retrieve Movie")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = {
            // Save to Room DB logic
        }) {
            Text("Save Movie to DB")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(movieInfo)
    }
}