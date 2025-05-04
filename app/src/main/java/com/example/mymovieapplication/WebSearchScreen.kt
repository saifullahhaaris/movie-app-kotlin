package com.example.mymovieapplication.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun WebSearchScreen() {
    var query by remember { mutableStateOf("") }
    var webResults by remember { mutableStateOf(listOf<String>()) }

    Column(modifier = Modifier.padding(16.dp)) {
        TextField(
            value = query,
            onValueChange = { query = it },
            label = { Text("Search Title") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = {
            // OMDb API call with substring search, store mock results
            webResults = listOf("The Matrix", "Matilda", "Aftermath")
        }) {
            Text("Search Web")
        }
        Spacer(modifier = Modifier.height(16.dp))
        webResults.forEach { result ->
            Text(result)
        }
    }
}
