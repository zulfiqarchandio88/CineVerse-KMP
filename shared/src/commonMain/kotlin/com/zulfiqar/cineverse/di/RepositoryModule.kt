package com.zulfiqar.cineverse.di

import com.zulfiqar.cineverse.data.repository.MovieRepositoryImpl
import com.zulfiqar.cineverse.domain.repository.MovieRepository
import org.koin.dsl.module

val repositoryModule = module {

    single<MovieRepository> {
        MovieRepositoryImpl(get())
    }
}