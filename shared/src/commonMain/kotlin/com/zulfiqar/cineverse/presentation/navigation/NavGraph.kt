package com.zulfiqar.cineverse.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.zulfiqar.cineverse.presentation.details.MovieDetailsScreen
import com.zulfiqar.cineverse.presentation.home.HomeScreen

@Composable
fun NavGraph() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {

        composable(Screen.Home.route) {

            HomeScreen(
                onMovieClick = { movieId ->
                    navController.navigate(
                        Screen.MovieDetails.createRoute(movieId)
                    )
                }
            )
        }

        composable(
            route = Screen.MovieDetails.route,
            arguments = listOf(
                navArgument("movieId") {
                    type = NavType.IntType
                }
            )
        ) {

            val movieId =
                it.arguments?.getInt("movieId") ?: 0

            MovieDetailsScreen(
                movieId = movieId,
                onBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}