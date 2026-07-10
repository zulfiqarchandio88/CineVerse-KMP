package com.zulfiqar.cineverse.di

import org.koin.core.context.startKoin

fun doInitKoin() {

    startKoin {

        modules(appModules)

    }
}
