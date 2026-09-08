package com.yeison.rick_and_morty.app.component

import android.content.res.Configuration
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.yeison.core.theme.RickAndMortyTheme
import com.yeison.rick_and_morty.app.state.HomeViewState

@Composable
fun HomeComponent(
    viewState: HomeViewState
) {

}

@Preview(showBackground = true)
@Composable
fun HomeComponentPreview() {
    RickAndMortyTheme {
        HomeComponent(
            viewState = HomeViewState()
        )
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun HomeComponentDarkPreview() {
    RickAndMortyTheme {
        HomeComponent(
            viewState = HomeViewState()
        )
    }
}
