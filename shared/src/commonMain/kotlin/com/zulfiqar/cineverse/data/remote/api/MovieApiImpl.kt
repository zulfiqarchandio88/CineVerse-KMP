package com.zulfiqar.cineverse.data.remote.api

import com.zulfiqar.cineverse.core.network.HttpRoutes
import com.zulfiqar.cineverse.core.network.NetworkConstants
import com.zulfiqar.cineverse.data.remote.dto.CastResponseDto
import com.zulfiqar.cineverse.data.remote.dto.MovieDetailsDto
import com.zulfiqar.cineverse.data.remote.dto.MovieResponseDto
import com.zulfiqar.cineverse.data.remote.dto.ReviewResponseDto
import com.zulfiqar.cineverse.data.remote.dto.VideoResponseDto
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class MovieApiImpl(
    private val client: HttpClient
) : MovieApi {

    override suspend fun getTrendingMovies(): MovieResponseDto {
        return client.get("${NetworkConstants.BASE_URL}${HttpRoutes.TRENDING}") {
            parameter("api_key", NetworkConstants.API_KEY)
        }.body()
    }

    override suspend fun getPopularMovies(): MovieResponseDto {
        return client.get("${NetworkConstants.BASE_URL}${HttpRoutes.POPULAR}") {
            parameter("api_key", NetworkConstants.API_KEY)
        }.body()
    }

    override suspend fun getTopRatedMovies(): MovieResponseDto {
        return client.get("${NetworkConstants.BASE_URL}${HttpRoutes.TOP_RATED}") {
            parameter("api_key", NetworkConstants.API_KEY)
        }.body()
    }

    override suspend fun getUpcomingMovies(): MovieResponseDto {
        return client.get("${NetworkConstants.BASE_URL}${HttpRoutes.UPCOMING}") {
            parameter("api_key", NetworkConstants.API_KEY)
        }.body()
    }

    override suspend fun searchMovies(query: String): MovieResponseDto {
        return client.get("${NetworkConstants.BASE_URL}${HttpRoutes.SEARCH}") {
            parameter("api_key", NetworkConstants.API_KEY)
            parameter("query", query)
        }.body()
    }

    override suspend fun getMovieDetails(movieId: Int): MovieDetailsDto {
        return client.get("${NetworkConstants.BASE_URL}${HttpRoutes.movieDetails(movieId)}") {
            parameter("api_key", NetworkConstants.API_KEY)
        }.body()
    }

    override suspend fun getMovieCast(movieId: Int): CastResponseDto {
        return client.get("${NetworkConstants.BASE_URL}${HttpRoutes.movieCredits(movieId)}") {
            parameter("api_key", NetworkConstants.API_KEY)
        }.body()
    }

    override suspend fun getMovieReviews(movieId: Int): ReviewResponseDto {
        return client.get("${NetworkConstants.BASE_URL}${HttpRoutes.movieReviews(movieId)}") {
            parameter("api_key", NetworkConstants.API_KEY)
        }.body()
    }

    override suspend fun getMovieTrailers(movieId: Int): VideoResponseDto {
        return client.get("${NetworkConstants.BASE_URL}${HttpRoutes.movieVideos(movieId)}") {
            parameter("api_key", NetworkConstants.API_KEY)
        }.body()
    }
}