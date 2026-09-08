package com.yeison.rick_and_morty.app.ui.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.yeison.rick_and_morty.app.ui.component.HomeComponent

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel()
) {
    val viewState by viewModel.viewState.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.getCharacters()
    }

    HomeComponent(
        viewState = viewState,
        onRetry = viewModel::getCharacters
    )
}