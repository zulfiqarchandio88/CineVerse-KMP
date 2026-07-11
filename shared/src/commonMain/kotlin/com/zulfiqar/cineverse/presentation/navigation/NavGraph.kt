package com.zulfiqar.cineverse.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.zulfiqar.cineverse.presentation.details.MovieDetailsScreen
import com.zulfiqar.cineverse.presentation.home.HomeScreen

@Composable
fun NavGraph() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Home
    ) {

        composable<Screen.Home> {

            HomeScreen(
                onMovieClick = { movieId ->
                    navController.navigate(
                        Screen.MovieDetails(movieId)
                    )
                }
            )
        }

        composable<Screen.MovieDetails> { backStackEntry ->
            val movieDetailsRoute: Screen.MovieDetails = backStackEntry.toRoute()

            MovieDetailsScreen(
                movieId = movieDetailsRoute.movieId,
                onBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}
