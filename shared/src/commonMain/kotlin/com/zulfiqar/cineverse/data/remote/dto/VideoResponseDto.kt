package com.zulfiqar.cineverse.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class VideoResponseDto(
    val id: Int,
    val results: List<VideoDto>
)