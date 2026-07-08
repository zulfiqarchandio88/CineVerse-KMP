package com.zulfiqar.cineverse.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AuthorDetailsDto(

    val name: String?,

    val username: String,

    @SerialName("avatar_path")
    val avatarPath: String?,

    val rating: Double?
)