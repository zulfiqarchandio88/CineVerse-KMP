package com.zulfiqar.cineverse.presentation.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil3.compose.AsyncImage
import com.zulfiqar.cineverse.core.extensions.oneDecimal
import com.zulfiqar.cineverse.core.platform.UrlLauncher
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.parameter.parametersOf

@Composable
fun MovieDetailsScreen(
    movieId: Int,
    onBack: () -> Unit
) {

    val viewModel: MovieDetailsViewModel = koinViewModel(
        parameters = { parametersOf(movieId) }
    )

    val state by viewModel.state.collectAsStateWithLifecycle()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF141414))
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
                    color = Color.White,
                    modifier = Modifier.align(Alignment.Center)
                )
            }

            state.movie != null -> {

                val movie = state.movie!!

                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .navigationBarsPadding(),
                    contentPadding = PaddingValues(bottom = 24.dp)
                ) {

                    item {

                        Box {

                            AsyncImage(
                                model = movie.backdropPath,
                                contentDescription = movie.title,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(280.dp),
                                contentScale = ContentScale.Crop
                            )

                            IconButton(
                                onClick = onBack,
                                modifier = Modifier
                                    .statusBarsPadding()
                                    .padding(16.dp)
                                    .background(
                                        Color.Black.copy(alpha = 0.5f),
                                        CircleShape
                                    )
                            ) {
                                Icon(
                                    imageVector = Icons.Default.ArrowBack,
                                    contentDescription = null,
                                    tint = Color.White
                                )
                            }
                        }
                    }

                    item {

                        Column(
                            modifier = Modifier.padding(20.dp)
                        ) {

                            Text(
                                text = movie.title,
                                style = MaterialTheme.typography.headlineMedium,
                                color = Color.White,
                                fontWeight = FontWeight.Bold
                            )

                            Spacer(Modifier.height(12.dp))

                            Text(
                                text = "⭐ ${movie.voteAverage.oneDecimal()}   •   ${movie.releaseDate.take(4)}",
                                color = Color.LightGray
                            )

                            Spacer(Modifier.height(24.dp))

                            Row(
                                horizontalArrangement = Arrangement.spacedBy(12.dp)
                            ) {

                                Button(
                                    onClick = {

                                        state.trailers.firstOrNull()?.let {

                                            UrlLauncher.openUrl(
                                                "https://www.youtube.com/watch?v=${it.key}"
                                            )
                                        }
                                    }
                                ) {

                                    Icon(
                                        Icons.Default.PlayArrow,
                                        contentDescription = null
                                    )

                                    Spacer(Modifier.width(6.dp))

                                    Text("Watch Trailer")
                                }

                                ElevatedButton(
                                    onClick = { }
                                ) {

                                    Icon(
                                        Icons.Default.FavoriteBorder,
                                        contentDescription = null
                                    )

                                    Spacer(Modifier.width(6.dp))

                                    Text("Watchlist")
                                }
                            }

                            Spacer(Modifier.height(28.dp))

                            Text(
                                "Overview",
                                style = MaterialTheme.typography.titleLarge,
                                color = Color.White,
                                fontWeight = FontWeight.Bold
                            )

                            Spacer(Modifier.height(8.dp))

                            Text(
                                text = movie.overview,
                                color = Color.LightGray
                            )

                            Spacer(Modifier.height(32.dp))

                            Text(
                                "Cast",
                                style = MaterialTheme.typography.titleLarge,
                                color = Color.White,
                                fontWeight = FontWeight.Bold
                            )

                            Spacer(Modifier.height(12.dp))

                            Text(
                                text = "${state.cast.size} Cast Members",
                                color = Color.LightGray
                            )

                            Spacer(Modifier.height(24.dp))

                            Text(
                                "Trailers",
                                style = MaterialTheme.typography.titleLarge,
                                color = Color.White,
                                fontWeight = FontWeight.Bold
                            )

                            Spacer(Modifier.height(12.dp))

                            Text(
                                text = "${state.trailers.size} Videos",
                                color = Color.LightGray
                            )

                            Spacer(Modifier.height(24.dp))

                            Text(
                                "Reviews",
                                style = MaterialTheme.typography.titleLarge,
                                color = Color.White,
                                fontWeight = FontWeight.Bold
                            )

                            Spacer(Modifier.height(12.dp))

                            Text(
                                text = "${state.reviews.size} Reviews",
                                color = Color.LightGray
                            )
                        }
                    }
                }
            }
        }
    }
}