package com.zulfiqar.cineverse.data.mapper

import com.zulfiqar.cineverse.data.remote.dto.CastDto
import com.zulfiqar.cineverse.data.remote.dto.GenreDto
import com.zulfiqar.cineverse.data.remote.dto.MovieDetailsDto
import com.zulfiqar.cineverse.data.remote.dto.MovieDto
import com.zulfiqar.cineverse.data.remote.dto.ReviewDto
import com.zulfiqar.cineverse.data.remote.dto.VideoDto
import com.zulfiqar.cineverse.domain.model.Cast
import com.zulfiqar.cineverse.domain.model.Genre
import com.zulfiqar.cineverse.domain.model.Movie
import com.zulfiqar.cineverse.domain.model.MovieDetails
import com.zulfiqar.cineverse.domain.model.Review
import com.zulfiqar.cineverse.domain.model.Trailer

private const val IMAGE_BASE_URL = "https://image.tmdb.org/t/p/w500"

fun MovieDto.toMovie(): Movie {
    return Movie(
        id = id,
        title = title,
        overview = overview,
        posterPath = posterPath?.let { IMAGE_BASE_URL + it } as String,
        backdropPath = backdropPath?.let { IMAGE_BASE_URL + it } as String,
        releaseDate = releaseDate,
        voteAverage = voteAverage,
        voteCount = voteCount,
        popularity = popularity,
        originalLanguage = originalLanguage,
        genreIds = genreIds,
        adult = adult,
        video = video
    )
}

fun MovieDetailsDto.toMovieDetails(): MovieDetails {
    return MovieDetails(
        id = id,
        title = title,
        overview = overview,
        posterPath = posterPath?.let { IMAGE_BASE_URL + it } ?: "",
        backdropPath = backdropPath?.let { IMAGE_BASE_URL + it } ?: "",
        releaseDate = releaseDate,
        voteAverage = voteAverage,
        runtime = runtime ?: 0,
        genres = genres.map { it.toGenre() },
        status = status ?: "",
        tagline = tagline ?: "",
        homepage = homepage
    )
}

fun MovieDetailsDto.toMovie(): Movie {
    return Movie(
        id = id,
        title = title,
        overview = overview,
        posterPath = posterPath?.let { IMAGE_BASE_URL + it } ?: "",
        backdropPath = backdropPath?.let { IMAGE_BASE_URL + it } ?: "",
        releaseDate = releaseDate,
        voteAverage = voteAverage,
        voteCount = voteCount,
        popularity = popularity,
        originalLanguage = originalLanguage,
        genreIds = genres.map { it.id },
        adult = adult,
        video = video
    )
}

fun GenreDto.toGenre(): Genre {
    return Genre(
        id = id,
        name = name
    )
}

fun CastDto.toCast(): Cast {
    return Cast(
        id = id,
        name = name,
        character = character,
        profilePath = profilePath?.let { IMAGE_BASE_URL + it } as String
    )
}

fun ReviewDto.toReview(): Review {
    return Review(
        id = id,
        author = author,
        content = content,
        avatarPath = authorDetails.avatarPath?.let {
            if (it.startsWith("/")) IMAGE_BASE_URL + it else it
        },
        rating = authorDetails.rating
    )
}

fun VideoDto.toTrailer(): Trailer {
    return Trailer(
        id = id,
        key = key,
        name = name,
        site = site,
        type = type
    )
}