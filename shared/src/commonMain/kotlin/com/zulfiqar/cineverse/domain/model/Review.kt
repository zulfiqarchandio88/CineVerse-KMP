package com.zulfiqar.cineverse.domain.model

data class Review(
    val id: String,
    val author: String,
    val content: String,
    val rating: Double?
)