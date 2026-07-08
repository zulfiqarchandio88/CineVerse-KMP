package com.zulfiqar.cineverse.domain.usecase

import com.zulfiqar.cineverse.domain.repository.MovieRepository

class SearchMoviesUseCase(
    private val repository: MovieRepository
) {
    suspend operator fun invoke(query: String) =
        repository.searchMovies(query)
}