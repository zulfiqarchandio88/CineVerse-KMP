package com.zulfiqar.cineverse.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MovieDetailsDto(

    val id: Int,

    val title: String,

    val overview: String,

    @SerialName("poster_path")
    val posterPath: String?,

    @SerialName("backdrop_path")
    val backdropPath: String?,

    @SerialName("release_date")
    val releaseDate: String,

    @SerialName("vote_average")
    val voteAverage: Double,

    @SerialName("vote_count")
    val voteCount: Int,

    val popularity: Double,

    val runtime: Int?,

    val adult: Boolean,

    val video: Boolean,

    @SerialName("original_language")
    val originalLanguage: String,

    val genres: List<GenreDto>
)