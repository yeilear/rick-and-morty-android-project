package com.yeison.core.extensions

val Long.Companion.ZERO: Long
    get() = 0L

fun Long?.orDefault(default: Long = Long.ZERO) = this ?: default