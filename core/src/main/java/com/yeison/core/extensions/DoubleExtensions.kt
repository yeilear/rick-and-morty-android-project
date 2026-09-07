package com.yeison.core.extensions

val Double.Companion.ZERO: Double
    get() = 0.0

fun Double?.orDefault(default: Double = 0.toDouble()) = this ?: default