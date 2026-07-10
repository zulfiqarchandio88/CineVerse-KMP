package com.zulfiqar.cineverse.presentation.details

sealed interface MovieDetailsUiAction {

    data object Retry : MovieDetailsUiAction

    data object ToggleFavorite : MovieDetailsUiAction

    data class PlayTrailer(
        val trailerKey: String
    ) : MovieDetailsUiAction
}