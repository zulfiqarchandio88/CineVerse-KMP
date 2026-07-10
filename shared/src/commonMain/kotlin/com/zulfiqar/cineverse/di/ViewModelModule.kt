package com.zulfiqar.cineverse.di

import com.zulfiqar.cineverse.presentation.details.MovieDetailsViewModel
import com.zulfiqar.cineverse.presentation.home.HomeViewModel
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val viewModelModule = module {
    factoryOf(::HomeViewModel)

    factory { (movieId: Int) ->
        MovieDetailsViewModel(
            movieId = movieId,
            useCases = get()
        )
    }
}