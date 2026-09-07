package com.yeison.rick_and_morty.ui.screens.splash

import androidx.lifecycle.viewModelScope
import com.yeison.core.base.BaseViewModel
import com.yeison.core.navigation.Routes
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor() : BaseViewModel() {

    private val _destination = MutableStateFlow<String?>(null)
    val destination = _destination.asStateFlow()

    fun onTimeout() = execute {
        viewModelScope.launch {
            _destination.value = Routes.Home.route
        }
    }
}
