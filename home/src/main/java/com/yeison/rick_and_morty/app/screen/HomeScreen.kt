package com.yeison.rick_and_morty.app.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.yeison.core.components.LoadingDialog
import com.yeison.rick_and_morty.app.component.HomeComponent

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel()
) {
    val viewState by viewModel.viewState.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.getCharacters()
    }

    LoadingDialog(isLoading = viewState.isLoading)

    HomeComponent(
        viewState = viewState
    )
}