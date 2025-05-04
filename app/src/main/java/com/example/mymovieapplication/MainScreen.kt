package com.example.mymovieapplication.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.movieapp.ui.AddMoviesScreen

@Composable
fun MainScreen(viewModel: MovieViewModel) {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "home") {
        composable("home") { HomeScreen(navController) }
        composable("add_movies") { AddMoviesScreen(viewModel) }
        composable("search_movie") { SearchMovieScreen() }
        composable("search_actor") { SearchActorScreen() }
        composable("web_search") { WebSearchScreen() }
    }
}

@Composable
fun HomeScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { navController.navigate("add_movies") }) {
            Text("Add Movies to DB")
        }
        Button(onClick = { navController.navigate("search_movie") }) {
            Text("Search for Movies")
        }
        Button(onClick = { navController.navigate("search_actor") }) {
            Text("Search for Actors")
        }
        Button(onClick = { navController.navigate("web_search") }) {
            Text("Web Search")
        }
    }
}