package com.zulfiqar.cineverse.di

import com.zulfiqar.cineverse.domain.usecase.AddToFavoritesUseCase
import com.zulfiqar.cineverse.domain.usecase.GetFavoriteMoviesUseCase
import com.zulfiqar.cineverse.domain.usecase.GetMovieCastUseCase
import com.zulfiqar.cineverse.domain.usecase.GetMovieDetailsUseCase
import com.zulfiqar.cineverse.domain.usecase.GetMovieReviewsUseCase
import com.zulfiqar.cineverse.domain.usecase.GetMovieTrailersUseCase
import com.zulfiqar.cineverse.domain.usecase.GetPopularMoviesUseCase
import com.zulfiqar.cineverse.domain.usecase.GetTopRatedMoviesUseCase
import com.zulfiqar.cineverse.domain.usecase.GetTrendingMoviesUseCase
import com.zulfiqar.cineverse.domain.usecase.GetUpcomingMoviesUseCase
import com.zulfiqar.cineverse.domain.usecase.IsFavoriteUseCase
import com.zulfiqar.cineverse.domain.usecase.MovieUseCases
import com.zulfiqar.cineverse.domain.usecase.RemoveFromFavoritesUseCase
import com.zulfiqar.cineverse.domain.usecase.SearchMoviesUseCase
import org.koin.dsl.module

val useCaseModule = module {

    factory { GetTrendingMoviesUseCase(get()) }
    factory { GetPopularMoviesUseCase(get()) }
    factory { GetTopRatedMoviesUseCase(get()) }
    factory { GetUpcomingMoviesUseCase(get()) }

    factory { SearchMoviesUseCase(get()) }

    factory { GetMovieDetailsUseCase(get()) }
    factory { GetMovieCastUseCase(get()) }
    factory { GetMovieReviewsUseCase(get()) }
    factory { GetMovieTrailersUseCase(get()) }

    factory { GetFavoriteMoviesUseCase(get()) }
    factory { AddToFavoritesUseCase(get()) }
    factory { RemoveFromFavoritesUseCase(get()) }
    factory { IsFavoriteUseCase(get()) }

    single {
        MovieUseCases(
            getTrendingMovies = get(),
            getPopularMovies = get(),
            getTopRatedMovies = get(),
            getUpcomingMovies = get(),
            searchMovies = get(),
            getMovieDetails = get(),
            getMovieCast = get(),
            getMovieReviews = get(),
            getMovieTrailers = get(),
            getFavoriteMovies = get(),
            addToFavorites = get(),
            removeFromFavorites = get(),
            isFavorite = get()
        )
    }
}