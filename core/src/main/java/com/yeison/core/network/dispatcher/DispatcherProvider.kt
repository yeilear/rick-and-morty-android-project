package com.yeison.core.network.dispatcher

import kotlinx.coroutines.CoroutineDispatcher

interface DispatcherProvider {
    val main: CoroutineDispatcher
    val network: CoroutineDispatcher
}