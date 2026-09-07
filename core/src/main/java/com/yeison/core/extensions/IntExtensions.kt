package com.yeison.core.extensions

val Int.Companion.ZERO: Int
    get() = 0

val Int.Companion.ONE: Int
    get() = 1

val Int.Companion.TWO: Int
    get() = 2

fun Int?.orDefault(default: Int = Int.ZERO) = this ?: default