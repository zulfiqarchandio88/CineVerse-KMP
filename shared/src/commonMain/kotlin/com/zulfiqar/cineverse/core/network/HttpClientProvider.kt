package com.zulfiqar.cineverse.core.network

import io.ktor.client.HttpClient

object HttpClientProvider {

    val client: HttpClient by lazy {
        HttpClientFactory.create()
    }
}