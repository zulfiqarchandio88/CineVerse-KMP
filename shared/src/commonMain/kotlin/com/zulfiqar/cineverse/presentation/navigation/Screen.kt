package com.zulfiqar.cineverse.presentation.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed interface Screen {

    @Serializable
    data object Home : Screen

    @Serializable
    data object Search : Screen

    @Serializable
    data object Favorites : Screen

    @Serializable
    data class MovieDetails(val movieId: Int) : Screen
}
