package com.yeison.rick_and_morty.app.screen

import com.yeison.core.base.BaseViewModel
import com.yeison.core.network.ResultDomain
import com.yeison.home.R
import com.yeison.rick_and_morty.app.state.HomeViewState
import com.yeison.rick_and_morty.domain.use_case.HomeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val homeUseCase: HomeUseCase
) : BaseViewModel() {

    private val _viewState = MutableStateFlow(HomeViewState())
    val viewState: StateFlow<HomeViewState> = _viewState.asStateFlow()

    private fun showLoader(show: Boolean){
        _viewState.update { it.copy(isLoading = show) }
    }

    fun getCharacters() = execute {
        showLoader(true)
        when (val result = homeUseCase.getCharacters()) {
            is ResultDomain.Success -> {
                val characters = result.data.results

                _viewState.update {
                    it.copy(
                        isLoading = false
                    )
                }
            }
            is ResultDomain.Error -> {
                // Create error message
            }
        }
        showLoader(false)
    }
}
