package com.yeison.core.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yeison.core.network.dispatcher.DispatcherProvider
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import javax.inject.Inject

abstract class BaseViewModel : ViewModel() {

    @Inject
    lateinit var appDispatcher: DispatcherProvider

    protected fun execute(
        dispatcher: CoroutineDispatcher = appDispatcher.main,
        action: suspend () -> Unit
    ) = viewModelScope.launch(dispatcher) { action() }
}