package com.zulfiqar.cineverse.domain.usecase

import com.zulfiqar.cineverse.domain.repository.MovieRepository

class GetTrendingMoviesUseCase(
    private val repository: MovieRepository
) {
    suspend operator fun invoke() =
        repository.getTrendingMovies()
}