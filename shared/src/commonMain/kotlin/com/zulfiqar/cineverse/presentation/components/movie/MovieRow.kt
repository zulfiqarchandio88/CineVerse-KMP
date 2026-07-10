package com.zulfiqar.cineverse.presentation.components.movie

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.zulfiqar.cineverse.domain.model.Movie

@Composable
fun MovieRow(
    movies: List<Movie>,
    onMovieClick: (Movie) -> Unit
) {

    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {

        items(
            items = movies,
            key = { it.id }
        ) { movie ->

            MovieCard(
                movie = movie,
                onClick = onMovieClick
            )
        }
    }
}