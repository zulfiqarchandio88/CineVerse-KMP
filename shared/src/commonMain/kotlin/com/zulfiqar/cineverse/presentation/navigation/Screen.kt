package com.zulfiqar.cineverse.presentation.navigation

sealed class Screen(val route: String) {

    data object Home : Screen("home")

    data object Search : Screen("search")

    data object Favorites : Screen("favorites")

    data object MovieDetails : Screen("movie_details/{movieId}") {

        fun createRoute(movieId: Int): String {
            return "movie_details/$movieId"
        }
    }
}