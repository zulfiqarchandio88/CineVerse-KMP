package com.zulfiqar.cineverse.di

import com.zulfiqar.cineverse.core.network.HttpClientFactory
import com.zulfiqar.cineverse.data.remote.api.MovieApi
import com.zulfiqar.cineverse.data.remote.api.MovieApiImpl
import org.koin.dsl.module

val networkModule = module {

    single {
        HttpClientFactory.create()
    }

    single<MovieApi> {
        MovieApiImpl(get())
    }
}