package com.zulfiqar.cineverse.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.zulfiqar.cineverse.presentation.components.common.HomeTopBar
import com.zulfiqar.cineverse.presentation.components.common.SectionTitle
import com.zulfiqar.cineverse.presentation.components.movie.FeaturedMovie
import com.zulfiqar.cineverse.presentation.components.movie.FeaturedMovieCarousel
import com.zulfiqar.cineverse.presentation.components.movie.MovieRow
import com.zulfiqar.cineverse.presentation.theme.Background
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun HomeScreen(
    onMovieClick: (Int) -> Unit,
    viewModel: HomeViewModel = koinViewModel()
) {

    val state by viewModel.state.collectAsStateWithLifecycle()

    Box(
        modifier = Modifier.fillMaxSize()
            .background(Background) // Netflix-like dark background
    ) {

        when {

            state.isLoading -> {

                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center)
                )
            }

            state.error != null -> {

                Text(
                    text = state.error!!,
                    color = MaterialTheme.colorScheme.error,
                    modifier = Modifier.align(Alignment.Center)
                )
            }

            else -> {

                LazyColumn(
                    modifier = Modifier.fillMaxSize()
                        .navigationBarsPadding(),
                    verticalArrangement = Arrangement.spacedBy(28.dp),
                    contentPadding = PaddingValues(bottom = 32.dp)
                ) {

                    item {
                        HomeTopBar(
                            modifier = Modifier.padding(horizontal = 20.dp)
                        )
                    }

                    if (state.trendingMovies.isNotEmpty()) {

                        item {

                            FeaturedMovieCarousel(
                                movies = state.trendingMovies,
                                onMovieClick = { movie ->
                                    onMovieClick(movie.id)
                                },
                                onPlayClick = { movie ->
                                    viewModel.playTrailer(movie.id)
                                }
                            )
                        }
                    }

                    item {
                        SectionTitle(
                            title = "Trending",
                            modifier = Modifier.padding(horizontal = 20.dp)
                        )
                    }

                    item {
                        MovieRow(
                            movies = state.trendingMovies,
                            onMovieClick = { movie ->
                                onMovieClick(movie.id)
                            }
                        )
                    }

                    item {
                        SectionTitle(
                            title = "Popular",
                            modifier = Modifier.padding(horizontal = 20.dp)
                        )
                    }

                    item {
                        MovieRow(
                            movies = state.popularMovies,
                            onMovieClick = { movie ->
                                onMovieClick(movie.id)
                            }
                        )
                    }

                    item {
                        SectionTitle(
                            title = "Top Picks",
                            modifier = Modifier.padding(horizontal = 20.dp)
                        )
                    }

                    item {
                        MovieRow(
                            movies = state.topRatedMovies,
                            onMovieClick = { movie ->
                                onMovieClick(movie.id)
                            }
                        )
                    }

                    item {
                        SectionTitle(
                            title = "New Releases",
                            modifier = Modifier.padding(horizontal = 20.dp)
                        )
                    }

                    item {
                        MovieRow(
                            movies = state.upcomingMovies,
                            onMovieClick = { movie ->
                                onMovieClick(movie.id)
                            }
                        )
                    }
                }
            }
        }
    }
}