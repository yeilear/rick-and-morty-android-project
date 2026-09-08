package com.yeison.rick_and_morty.app.ui.screen

import com.yeison.core.base.BaseViewModel
import com.yeison.core.network.ResultDomain
import com.yeison.home.R
import com.yeison.rick_and_morty.app.state.HomeUiState
import com.yeison.rick_and_morty.domain.errors.GetCharactersErrorDomain
import com.yeison.rick_and_morty.domain.use_case.HomeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val homeUseCase: HomeUseCase
) : BaseViewModel() {

    private val _viewState = MutableStateFlow<HomeUiState>(HomeUiState.Loading)
    val viewState: StateFlow<HomeUiState> = _viewState.asStateFlow()

    fun getCharacters() = execute {
        _viewState.value = HomeUiState.Loading
        when (val result = homeUseCase.getCharacters()) {
            is ResultDomain.Success -> {
                _viewState.value = HomeUiState.Success(result.data.results)
            }
            is ResultDomain.Error -> {
                _viewState.value = HomeUiState.Error(
                    when (result.error){
                        GetCharactersErrorDomain.CharactersNotFoundError -> R.string.home_not_found_error_message
                        else -> R.string.home_error_message
                    }
                )
            }
        }
    }
}