package com.zulfiqar.cineverse.di

import com.zulfiqar.cineverse.domain.usecase.*
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