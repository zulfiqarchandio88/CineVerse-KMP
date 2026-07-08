package com.zulfiqar.cineverse.data.remote.datasource

import com.zulfiqar.cineverse.data.remote.api.MovieApi

class MovieRemoteDataSource(
    private val api: MovieApi
) {

    suspend fun getTrendingMovies() =
        api.getTrendingMovies()

    suspend fun getPopularMovies() =
        api.getPopularMovies()

    suspend fun getTopRatedMovies() =
        api.getTopRatedMovies()

    suspend fun getUpcomingMovies() =
        api.getUpcomingMovies()

    suspend fun searchMovies(query: String) =
        api.searchMovies(query)

    suspend fun getMovieDetails(movieId: Int) =
        api.getMovieDetails(movieId)

    suspend fun getMovieCast(movieId: Int) =
        api.getMovieCast(movieId)

    suspend fun getMovieReviews(movieId: Int) =
        api.getMovieReviews(movieId)

    suspend fun getMovieTrailers(movieId: Int) =
        api.getMovieTrailers(movieId)
}