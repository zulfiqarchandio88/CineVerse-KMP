package com.zulfiqar.cineverse.presentation.home

import com.zulfiqar.cineverse.domain.model.Movie

class HomeContract {

    data class State(

        val isLoading: Boolean = false,

        val trendingMovies: List<Movie> = emptyList(),

        val popularMovies: List<Movie> = emptyList(),

        val topRatedMovies: List<Movie> = emptyList(),

        val upcomingMovies: List<Movie> = emptyList(),

        val error: String? = null
    )

    sealed interface Event {

        data object LoadMovies : Event

        data object Refresh : Event
    }

    sealed interface Effect {

        data class ShowError(
            val message: String
        ) : Effect
    }
}