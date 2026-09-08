package com.yeison.rick_and_morty.app.state

import com.yeison.rick_and_morty.domain.model.ResultsEntity

sealed class HomeUiState {
    data object Loading : HomeUiState()
    data class Success(val characters: List<ResultsEntity>) : HomeUiState()
    data class Error(val message: Int) : HomeUiState()
}