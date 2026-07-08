package com.zulfiqar.cineverse.core.common

suspend inline fun <T> safeApiCall(
    crossinline block: suspend () -> T
): Result<T> {

    return try {
        Result.Success(block())
    } catch (e: Exception) {
        Result.Error(
            e.message ?: "Unknown error occurred"
        )
    }
}