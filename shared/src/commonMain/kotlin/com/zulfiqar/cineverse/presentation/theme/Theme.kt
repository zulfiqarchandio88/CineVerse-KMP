package com.zulfiqar.cineverse.presentation.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable

private val DarkScheme = darkColorScheme(

    primary = PrimaryRed,

    background = Background,

    surface = Surface,

    onPrimary = White,

    onBackground = White,

    onSurface = White
)

@Composable
fun CineVerseTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = DarkScheme,
        typography = Typography,
        content = content
    )
}