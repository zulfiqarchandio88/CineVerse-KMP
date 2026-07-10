package com.zulfiqar.cineverse.data.repository

import com.zulfiqar.cineverse.core.common.Result
import com.zulfiqar.cineverse.core.common.safeApiCall
import com.zulfiqar.cineverse.data.mapper.toDomain
import com.zulfiqar.cineverse.data.remote.api.MovieApi
import com.zulfiqar.cineverse.domain.model.Cast
import com.zulfiqar.cineverse.domain.model.Genre
import com.zulfiqar.cineverse.domain.model.Movie
import com.zulfiqar.cineverse.domain.model.MovieDetails
import com.zulfiqar.cineverse.domain.model.Review
import com.zulfiqar.cineverse.domain.model.Trailer
import com.zulfiqar.cineverse.domain.repository.MovieRepository

class MovieRepositoryImpl(
    private val api: MovieApi
) : MovieRepository {

    override suspend fun getTrendingMovies(): Result<List<Movie>> =
        safeApiCall {
            api.getTrendingMovies().results.map { it.toDomain() }
        }

    override suspend fun getPopularMovies(): Result<List<Movie>> =
        safeApiCall {
            api.getPopularMovies().results.map { it.toDomain() }
        }

    override suspend fun getTopRatedMovies(): Result<List<Movie>> =
        safeApiCall {
            api.getTopRatedMovies().results.map { it.toDomain() }
        }

    override suspend fun getUpcomingMovies(): Result<List<Movie>> =
        safeApiCall {
            api.getUpcomingMovies().results.map { it.toDomain() }
        }

    override suspend fun searchMovies(query: String): Result<List<Movie>> =
        safeApiCall {
            api.searchMovies(query).results.map { it.toDomain() }
        }

    override suspend fun getMovieDetails(movieId: Int): Result<MovieDetails> =
        safeApiCall {
            api.getMovieDetails(movieId).toDomain()
        }

    override suspend fun getMovieGenres(): Result<List<Genre>> {
        TODO("Not yet implemented")
    }

    override suspend fun getMovieCast(movieId: Int): Result<List<Cast>> =
        safeApiCall {
            api.getMovieCast(movieId).cast.map { it.toDomain() }
        }

    override suspend fun getMovieReviews(movieId: Int): Result<List<Review>> =
        safeApiCall {
            api.getMovieReviews(movieId).results.map { it.toDomain() }
        }

    override suspend fun getMovieTrailers(movieId: Int): Result<List<Trailer>> =
        safeApiCall {
            api.getMovieTrailers(movieId).results.map { it.toDomain() }
        }

    // Temporary implementations
    override suspend fun getFavoriteMovies(): Result<List<Movie>> {
        return Result.Success(emptyList())
    }

    override suspend fun addToFavorites(movie: Movie) {
        // TODO: SQLDelight implementation
    }

    override suspend fun removeFromFavorites(movieId: Int) {
        // TODO: SQLDelight implementation
    }

    override suspend fun isFavorite(movieId: Int): Boolean {
        return false
    }
}