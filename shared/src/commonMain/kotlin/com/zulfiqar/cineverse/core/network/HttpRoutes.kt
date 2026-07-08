package com.zulfiqar.cineverse.core.network

object HttpRoutes {

    const val TRENDING = "/trending/movie/week"

    const val POPULAR = "/movie/popular"

    const val TOP_RATED = "/movie/top_rated"

    const val UPCOMING = "/movie/upcoming"

    const val SEARCH = "/search/movie"

    fun movieDetails(movieId: Int) =
        "/movie/$movieId"

    fun movieCredits(movieId: Int) =
        "/movie/$movieId/credits"

    fun movieReviews(movieId: Int) =
        "/movie/$movieId/reviews"

    fun movieVideos(movieId: Int) =
        "/movie/$movieId/videos"
}