package com.zulfiqar.cineverse.presentation.components.movie

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.zulfiqar.cineverse.core.extensions.oneDecimal
import com.zulfiqar.cineverse.domain.model.Movie

@Composable
fun FeaturedMovie(
    movie: Movie,
    onClick: (Movie) -> Unit,
    onPlayClick: (Movie) -> Unit,
    modifier: Modifier = Modifier
) {

    val year = movie.releaseDate.take(4)

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(430.dp)
            .clickable {
                onClick(movie)
            }

    ) {

        AsyncImage(
            model = movie.backdropPath,
            contentDescription = movie.title,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Box(
            modifier = Modifier
                .matchParentSize()
                .background(
                    Brush.verticalGradient(
                        0f to Color.Transparent,
                        0.55f to Color.Transparent,
                        1f to Color(0xFF121212)
                    )
                )
        )

        Column(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(20.dp)
        ) {

            Text(
                text = movie.title,
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

            Spacer(Modifier.height(10.dp))

            Row(
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {

                Text(
                    "⭐ ${movie.voteAverage.oneDecimal()}",
                    color = Color.White
                )

                Text(
                    year,
                    color = Color.LightGray
                )

                Text(
                    "HD",
                    color = Color.Green
                )
            }

            Spacer(Modifier.height(14.dp))

            Text(
                text = movie.overview,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
                color = Color.White
            )

            Spacer(Modifier.height(20.dp))

            Row {

                Button(
                    onClick = { onPlayClick(movie) },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White,
                        contentColor = Color.Black
                    ),
                    shape = RoundedCornerShape(10.dp)
                ) {

                    Icon(
                        Icons.Default.PlayArrow,
                        null
                    )

                    Spacer(Modifier.width(6.dp))

                    Text("Play")
                }

                Spacer(Modifier.width(12.dp))

                OutlinedButton(
                    onClick = {},
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.outlinedButtonColors(
                        contentColor = Color.White
                    )
                ) {

                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = null
                    )

                    Spacer(Modifier.width(6.dp))

                    Text(
                        text = "Watchlist",
                        color = Color.White
                    )
                }
            }
        }
    }
}