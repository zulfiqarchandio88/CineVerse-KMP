package com.zulfiqar.cineverse.domain.model

data class Movie(
    val id: Int,
    val title: String,
    val overview: String,
    val posterPath: String,
    val backdropPath: String,
    val releaseDate: String,
    val voteAverage: Double,
    val voteCount: Int,
    val popularity: Double,
    val originalLanguage: String,
    val genreIds: List<Int>,
    val adult: Boolean,
    val video: Boolean
)