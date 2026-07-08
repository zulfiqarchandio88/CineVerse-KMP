package com.zulfiqar.cineverse.di

import org.koin.core.context.startKoin

fun initKoin() {

    startKoin {

        modules(appModules)

    }
}