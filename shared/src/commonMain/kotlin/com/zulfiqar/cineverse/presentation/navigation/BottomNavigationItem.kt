package com.zulfiqar.cineverse.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavigationItem(
    val title: String,
    val icon: ImageVector,
    val screen: Screen
)

val bottomItems = listOf(
    BottomNavigationItem(
        title = "Home",
        icon = Icons.Default.Home,
        screen = Screen.Home
    ),
    BottomNavigationItem(
        title = "Search",
        icon = Icons.Default.Search,
        screen = Screen.Search
    ),
    BottomNavigationItem(
        title = "Favorites",
        icon = Icons.Default.Favorite,
        screen = Screen.Favorites
    )
)
