package com.zulfiqar.cineverse.presentation.details

import com.zulfiqar.cineverse.domain.model.Cast
import com.zulfiqar.cineverse.domain.model.MovieDetails
import com.zulfiqar.cineverse.domain.model.Review
import com.zulfiqar.cineverse.domain.model.Trailer

data class MovieDetailsState(

    val isLoading: Boolean = false,

    val movie: MovieDetails? = null,

    val cast: List<Cast> = emptyList(),

    val trailers: List<Trailer> = emptyList(),

    val reviews: List<Review> = emptyList(),

    val isFavorite: Boolean = false,

    val error: String? = null
)