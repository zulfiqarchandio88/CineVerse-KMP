package com.zulfiqar.cineverse.domain.usecase

import com.zulfiqar.cineverse.domain.model.Movie
import com.zulfiqar.cineverse.domain.repository.MovieRepository

class AddToFavoritesUseCase(
    private val repository: MovieRepository
) {
    suspend operator fun invoke(movie: Movie) =
        repository.addToFavorites(movie)
}