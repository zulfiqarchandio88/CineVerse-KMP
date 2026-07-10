package com.zulfiqar.cineverse.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zulfiqar.cineverse.core.common.Result
import com.zulfiqar.cineverse.core.platform.UrlLauncher
import com.zulfiqar.cineverse.domain.usecase.MovieUseCases
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeViewModel(
    private val useCases: MovieUseCases
) : ViewModel() {

    private val _state = MutableStateFlow(HomeContract.State())
    val state = _state.asStateFlow()

    init {
        onEvent(HomeContract.Event.LoadMovies)
    }

    fun onEvent(event: HomeContract.Event) {
        when (event) {
            HomeContract.Event.LoadMovies -> loadMovies()
            HomeContract.Event.Refresh -> loadMovies()
        }
    }

    private fun loadMovies() {

        viewModelScope.launch {

            _state.value = _state.value.copy(
                isLoading = true,
                error = null
            )

            coroutineScope {

                val trending = async { useCases.getTrendingMovies() }
                val popular = async { useCases.getPopularMovies() }
                val topRated = async { useCases.getTopRatedMovies() }
                val upcoming = async { useCases.getUpcomingMovies() }

                _state.value = HomeContract.State(
                    isLoading = false,
                    trendingMovies = (trending.await() as? Result.Success)?.data ?: emptyList(),
                    popularMovies = (popular.await() as? Result.Success)?.data ?: emptyList(),
                    topRatedMovies = (topRated.await() as? Result.Success)?.data ?: emptyList(),
                    upcomingMovies = (upcoming.await() as? Result.Success)?.data ?: emptyList()
                )
            }
        }
    }

    fun playTrailer(movieId: Int) {

        viewModelScope.launch {

            when (val result = useCases.getMovieTrailers(movieId)) {

                is Result.Success -> {

                    result.data.firstOrNull()?.let {

                        UrlLauncher.openUrl(
                            "https://www.youtube.com/watch?v=${it.key}"
                        )
                    }
                }

                is Result.Error -> {
                    // Show snackbar/toast if no trailer is available
                }

                else -> {}
            }
        }
    }
}