package com.yeison.rick_and_morty.ui.screens

import com.yeison.core.base.BaseViewModel
import com.yeison.core.navigation.Routes
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

private const val DELAY = 2000L

@HiltViewModel
class SplashViewModel @Inject constructor() : BaseViewModel() {

    private val _destination = MutableStateFlow<String?>(null)
    val destination = _destination.asStateFlow()

    fun onTimeout() = execute {
        delay(DELAY)
        _destination.value = Routes.Home.route
    }
}
