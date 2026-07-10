package com.zulfiqar.cineverse.domain.model

data class MovieDetails(

    val id: Int,

    val title: String,

    val overview: String,

    val posterPath: String,

    val backdropPath: String,

    val voteAverage: Double,

    val releaseDate: String,

    val runtime: Int,

    val genres: List<Genre>,

    val status: String,

    val tagline: String,

    val homepage: String?
)