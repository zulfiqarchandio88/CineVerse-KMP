package com.zulfiqar.cineverse.di

import org.koin.core.module.Module

val appModules: List<Module> = listOf(

    networkModule,

    repositoryModule,

    useCaseModule,

    viewModelModule
)