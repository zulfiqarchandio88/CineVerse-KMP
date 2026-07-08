package com.zulfiqar.cineverse.domain.usecase

import com.zulfiqar.cineverse.domain.repository.MovieRepository

class GetTopRatedMoviesUseCase(
    private val repository: MovieRepository
) {
    suspend operator fun invoke() =
        repository.getTopRatedMovies()
}