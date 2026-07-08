package com.zulfiqar.cineverse

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform