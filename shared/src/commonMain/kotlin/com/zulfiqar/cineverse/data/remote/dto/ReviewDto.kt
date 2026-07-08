package com.zulfiqar.cineverse.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ReviewDto(

    val id: String,

    val author: String,

    val content: String,

    @SerialName("author_details")
    val authorDetails: AuthorDetailsDto
)