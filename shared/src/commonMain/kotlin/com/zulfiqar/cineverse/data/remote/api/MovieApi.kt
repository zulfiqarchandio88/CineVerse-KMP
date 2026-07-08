package com.zulfiqar.cineverse.data.remote.api

import com.zulfiqar.cineverse.data.remote.dto.CastResponseDto
import com.zulfiqar.cineverse.data.remote.dto.MovieDetailsDto
import com.zulfiqar.cineverse.data.remote.dto.MovieResponseDto
import com.zulfiqar.cineverse.data.remote.dto.ReviewResponseDto
import com.zulfiqar.cineverse.data.remote.dto.VideoResponseDto

interface MovieApi {

    suspend fun getTrendingMovies(): MovieResponseDto

    suspend fun getPopularMovies(): MovieResponseDto

    suspend fun getTopRatedMovies(): MovieResponseDto

    suspend fun getUpcomingMovies(): MovieResponseDto

    suspend fun searchMovies(query: String): MovieResponseDto

    suspend fun getMovieDetails(movieId: Int): MovieDetailsDto

    suspend fun getMovieCast(movieId: Int): CastResponseDto

    suspend fun getMovieReviews(movieId: Int): ReviewResponseDto

    suspend fun getMovieTrailers(movieId: Int): VideoResponseDto
}