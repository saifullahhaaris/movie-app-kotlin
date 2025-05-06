package com.example.mymovieapplication.data

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun HomeScreen(
    onAddMoviesClick: () -> Unit,
    onSearchMovieClick: () -> Unit,
    onSearchActorClick: () -> Unit,
    onWebSearchClick: () -> Unit,
    paddingValues: PaddingValues
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.SpaceAround
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = paddingValues.calculateTopPadding() + 16.dp) //padding below notification bar
                .padding(bottom = 32.dp), //space before buttons
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "Hello Movie Buff!",
                style = TextStyle(
                    fontSize = 36.sp,
                    color = Color.White
                ),
                modifier = Modifier.padding(bottom = 4.dp)
            )
            Text(
                text = "Welcome to the Movieverse.",
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontSize = 26.sp
                ),
                color = Color.Gray
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Button(onClick = onAddMoviesClick, modifier = Modifier.fillMaxWidth()) { Text("Add Movies to DB") }
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = onSearchMovieClick, modifier = Modifier.fillMaxWidth()) { Text("Search for Movies") }
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = onSearchActorClick, modifier = Modifier.fillMaxWidth()) { Text("Search for Actors") }
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = onWebSearchClick, modifier = Modifier.fillMaxWidth()) { Text("Web Search") }
        }

        Spacer(modifier = Modifier.height(paddingValues.calculateBottomPadding()))
    }
}