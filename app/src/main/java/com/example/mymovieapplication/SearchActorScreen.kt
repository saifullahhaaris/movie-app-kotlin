package com.example.mymovieapplication.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SearchActorScreen() {
    var actorQuery by remember { mutableStateOf("") }
    var results by remember { mutableStateOf(listOf<String>()) }

    Column(modifier = Modifier.padding(16.dp)) {
        TextField(
            value = actorQuery,
            onValueChange = { actorQuery = it },
            label = { Text("Search Actor") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = {
            // Filter from Room DB (case insensitive, partial match)
            results = listOf("Movie A", "Movie B") // mock
        }) {
            Text("Search")
        }
        Spacer(modifier = Modifier.height(16.dp))
        results.forEach { movie ->
            Text(movie)
        }
    }
}