package com.zulfiqar.cineverse.core.extensions

import kotlin.math.round

fun Double.oneDecimal(): Double {
    return round(this * 10) / 10
}