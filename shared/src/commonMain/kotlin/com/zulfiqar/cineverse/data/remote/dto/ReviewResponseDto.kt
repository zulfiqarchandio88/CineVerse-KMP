package com.zulfiqar.cineverse.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class ReviewResponseDto(
    val page: Int,
    val results: List<ReviewDto>
)