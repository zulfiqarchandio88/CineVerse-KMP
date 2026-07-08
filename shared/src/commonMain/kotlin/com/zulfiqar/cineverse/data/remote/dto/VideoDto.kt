package com.zulfiqar.cineverse.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class VideoDto(

    val id: String,

    val key: String,

    val name: String,

    val site: String,

    val type: String
)