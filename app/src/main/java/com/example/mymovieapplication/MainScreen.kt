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
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.movieapp.ui.AddMoviesScreen
import com.example.mymovieapplication.data.HomeScreen

@Composable
fun MainScreen(
    navController: NavHostController = rememberNavController(),
    viewModel: MovieViewModel = hiltViewModel()
) {
    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable("home") {
            HomeScreen(
                onAddMoviesClick = { navController.navigate("add_movies") },
                onSearchMovieClick = { navController.navigate("search_movie") },
                onSearchActorClick = { navController.navigate("search_actor") },
                onWebSearchClick = { navController.navigate("web_search") }
            )
        }
        composable("add_movies") {
            AddMoviesScreen(viewModel)
        }
        composable("search_movie") {
            SearchMovieScreen() //viewModel
        }
        composable("search_actor") {
            SearchActorScreen() //viewModel
        }
        composable("web_search") {
            WebSearchScreen() //viewModel
        }
    }
}