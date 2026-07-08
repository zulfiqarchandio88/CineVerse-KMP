package com.zulfiqar.cineverse.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class CastResponseDto(
    val id: Int,
    val cast: List<CastDto>
)