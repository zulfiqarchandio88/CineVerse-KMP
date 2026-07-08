package com.zulfiqar.cineverse.domain.usecase

data class MovieUseCases(

    val getTrendingMovies: GetTrendingMoviesUseCase,

    val getPopularMovies: GetPopularMoviesUseCase,

    val getTopRatedMovies: GetTopRatedMoviesUseCase,

    val getUpcomingMovies: GetUpcomingMoviesUseCase,

    val searchMovies: SearchMoviesUseCase,

    val getMovieDetails: GetMovieDetailsUseCase,

    val getMovieCast: GetMovieCastUseCase,

    val getMovieReviews: GetMovieReviewsUseCase,

    val getMovieTrailers: GetMovieTrailersUseCase,

    val getFavoriteMovies: GetFavoriteMoviesUseCase,

    val addToFavorites: AddToFavoritesUseCase,

    val removeFromFavorites: RemoveFromFavoritesUseCase,

    val isFavorite: IsFavoriteUseCase
)