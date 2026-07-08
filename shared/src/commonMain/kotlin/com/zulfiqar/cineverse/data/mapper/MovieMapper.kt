package com.zulfiqar.cineverse.data.mapper

import com.zulfiqar.cineverse.domain.model.Cast
import com.zulfiqar.cineverse.domain.model.Genre
import com.zulfiqar.cineverse.domain.model.Movie
import com.zulfiqar.cineverse.domain.model.Review
import com.zulfiqar.cineverse.domain.model.Trailer
import com.zulfiqar.cineverse.data.remote.dto.CastDto
import com.zulfiqar.cineverse.data.remote.dto.GenreDto
import com.zulfiqar.cineverse.data.remote.dto.MovieDetailsDto
import com.zulfiqar.cineverse.data.remote.dto.MovieDto
import com.zulfiqar.cineverse.data.remote.dto.ReviewDto
import com.zulfiqar.cineverse.data.remote.dto.VideoDto

private const val IMAGE_BASE_URL = "https://image.tmdb.org/t/p/w500"

fun MovieDto.toDomain(): Movie {
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

fun MovieDetailsDto.toDomain(): Movie {
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
        genreIds = genres.map { it.id },
        adult = adult,
        video = video
    )
}

fun GenreDto.toDomain(): Genre {
    return Genre(
        id = id,
        name = name
    )
}

fun CastDto.toDomain(): Cast {
    return Cast(
        id = id,
        name = name,
        character = character,
        profilePath = profilePath?.let { IMAGE_BASE_URL + it } as String
    )
}

fun ReviewDto.toDomain(): Review {
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

fun VideoDto.toDomain(): Trailer {
    return Trailer(
        id = id,
        key = key,
        name = name,
        site = site,
        type = type
    )
}