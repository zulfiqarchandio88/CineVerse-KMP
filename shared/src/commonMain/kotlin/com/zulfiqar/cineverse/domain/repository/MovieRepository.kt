package com.zulfiqar.cineverse.domain.repository

import com.zulfiqar.cineverse.core.common.Result
import com.zulfiqar.cineverse.domain.model.Cast
import com.zulfiqar.cineverse.domain.model.Genre
import com.zulfiqar.cineverse.domain.model.Movie
import com.zulfiqar.cineverse.domain.model.MovieDetails
import com.zulfiqar.cineverse.domain.model.Review
import com.zulfiqar.cineverse.domain.model.Trailer

interface MovieRepository {

    suspend fun getTrendingMovies(): Result<List<Movie>>

    suspend fun getPopularMovies(): Result<List<Movie>>

    suspend fun getTopRatedMovies(): Result<List<Movie>>

    suspend fun getUpcomingMovies(): Result<List<Movie>>

    suspend fun searchMovies(query: String): Result<List<Movie>>

    suspend fun getMovieDetails(movieId: Int): Result<MovieDetails>

    suspend fun getMovieGenres(): Result<List<Genre>>

    suspend fun getMovieCast(movieId: Int): Result<List<Cast>>

    suspend fun getMovieReviews(movieId: Int): Result<List<Review>>

    suspend fun getMovieTrailers(movieId: Int): Result<List<Trailer>>

    suspend fun getFavoriteMovies(): Result<List<Movie>>

    suspend fun addToFavorites(movie: Movie)

    suspend fun removeFromFavorites(movieId: Int)

    suspend fun isFavorite(movieId: Int): Boolean
}