package com.yeison.core.extensions

import com.yeison.core.utils.EMPTY_STRING

fun String?.orDefault(default: String = EMPTY_STRING) = this ?: default