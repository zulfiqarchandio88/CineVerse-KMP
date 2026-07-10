package com.zulfiqar.cineverse.presentation.components.movie

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun PagerIndicator(
    pageCount: Int,
    currentPage: Int
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 18.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.Bottom
    ) {

        repeat(pageCount) { index ->

            Box(
                modifier = Modifier
                    .padding(horizontal = 4.dp)
                    .size(
                        if (index == currentPage) 10.dp else 8.dp
                    )
                    .background(
                        if (index == currentPage)
                            Color.White
                        else
                            Color.Gray,
                        CircleShape
                    )
            )
        }
    }
}