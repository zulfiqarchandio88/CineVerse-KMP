package com.zulfiqar.cineverse.domain.usecase

import com.zulfiqar.cineverse.domain.repository.MovieRepository

class GetMovieCastUseCase(
    private val repository: MovieRepository
) {
    suspend operator fun invoke(movieId: Int) =
        repository.getMovieCast(movieId)
}