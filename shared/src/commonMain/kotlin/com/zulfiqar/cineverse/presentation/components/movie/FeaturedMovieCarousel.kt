package com.zulfiqar.cineverse.presentation.components.movie

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.zulfiqar.cineverse.domain.model.Movie
import kotlinx.coroutines.delay

@Composable
fun FeaturedMovieCarousel(
    movies: List<Movie>,
    onMovieClick: (Movie) -> Unit,
    onPlayClick: (Movie) -> Unit
) {

    if (movies.isEmpty()) return

    val featuredMovies = movies.take(5)

    val pagerState = rememberPagerState {
        featuredMovies.size
    }

    LaunchedEffect(pagerState) {
        while (true) {

            delay(4000)

            if (!pagerState.isScrollInProgress) {

                val nextPage =
                    (pagerState.currentPage + 1) % featuredMovies.size

                pagerState.animateScrollToPage(nextPage)
            }
        }
    }

    Box(
        modifier = Modifier.fillMaxWidth()
    ) {

        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .height(430.dp)
        ) { page ->

            FeaturedMovie(
                movie = featuredMovies[page],
                onClick = onMovieClick,
                onPlayClick = onPlayClick
            )
        }

        Box(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 20.dp)   // Increase to 24.dp or 32.dp if needed
        ) {
            PagerIndicator(
                pageCount = featuredMovies.size,
                currentPage = pagerState.currentPage
            )
        }
    }
}