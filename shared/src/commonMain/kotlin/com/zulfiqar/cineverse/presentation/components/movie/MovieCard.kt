package com.zulfiqar.cineverse.presentation.components.movie

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.zulfiqar.cineverse.core.extensions.oneDecimal
import com.zulfiqar.cineverse.domain.model.Movie

@Composable
fun MovieCard(
    movie: Movie,
    onClick: (Movie) -> Unit
) {

    val year = movie.releaseDate.take(4)

    Column(
        modifier = Modifier
            .width(135.dp)
            .clickable { onClick(movie) },
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        MoviePoster(
            imageUrl = movie.posterPath
        )

        Text(
            text = movie.title,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.titleSmall,
            fontWeight = FontWeight.SemiBold,
            color = Color.White
        )

        Text(
            text = year,
            style = MaterialTheme.typography.bodySmall,
            color = Color.Gray
        )

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            Icon(
                imageVector = Icons.Default.Star,
                contentDescription = null,
                tint = Color(0xFFFFC107),
                modifier = Modifier.height(14.dp)
            )

            Spacer(modifier = Modifier.width(4.dp))

            Text(
                text = movie.voteAverage.oneDecimal().toString(),
                style = MaterialTheme.typography.bodySmall,
                color = Color.White
            )
        }
    }
}