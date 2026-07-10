package com.zulfiqar.cineverse

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.zulfiqar.cineverse.presentation.home.HomeScreen
import com.zulfiqar.cineverse.presentation.navigation.NavGraph
import com.zulfiqar.cineverse.presentation.theme.CineVerseTheme

@Composable
@Preview
fun App() {
//    MaterialTheme {
//        HomeScreen()
//    }
    CineVerseTheme {

        NavGraph()
    }
}