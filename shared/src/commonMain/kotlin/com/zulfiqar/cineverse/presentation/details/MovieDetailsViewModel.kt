package com.zulfiqar.cineverse.presentation.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zulfiqar.cineverse.core.common.Result
import com.zulfiqar.cineverse.domain.usecase.MovieUseCases
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MovieDetailsViewModel(
    private val movieId: Int,
    private val useCases: MovieUseCases
) : ViewModel() {

    private val _state = MutableStateFlow(MovieDetailsState())
    val state: StateFlow<MovieDetailsState> = _state.asStateFlow()

    init {
        loadMovie()
    }

    private fun loadMovie() {

        viewModelScope.launch {

            _state.value = _state.value.copy(
                isLoading = true,
                error = null
            )

            val detailsDeferred = async {
                useCases.getMovieDetails(movieId)
            }

            val castDeferred = async {
                useCases.getMovieCast(movieId)
            }

            val trailersDeferred = async {
                useCases.getMovieTrailers(movieId)
            }

            val reviewsDeferred = async {
                useCases.getMovieReviews(movieId)
            }

            val details = detailsDeferred.await()
            val cast = castDeferred.await()
            val trailers = trailersDeferred.await()
            val reviews = reviewsDeferred.await()

            when (details) {

                is Result.Success -> {

                    _state.value = _state.value.copy(
                        isLoading = false,
                        movie = details.data,
                        cast = (cast as? Result.Success)?.data ?: emptyList(),
                        trailers = (trailers as? Result.Success)?.data ?: emptyList(),
                        reviews = (reviews as? Result.Success)?.data ?: emptyList()
                    )
                }

                is Result.Error -> {

                    _state.value = _state.value.copy(
                        isLoading = false,
                        error = details.message
                    )
                }

                else -> {}
            }
        }
    }

    fun onAction(action: MovieDetailsUiAction) {

        when (action) {

            MovieDetailsUiAction.Retry -> loadMovie()

            MovieDetailsUiAction.ToggleFavorite -> {
                // later
            }

            is MovieDetailsUiAction.PlayTrailer -> {
                // later
            }
        }
    }
}