package com.yeison.rick_and_morty.app.ui.component

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.yeison.core.theme.RickAndMortyTheme
import com.yeison.core.utils.Dimens
import com.yeison.home.R
import com.yeison.rick_and_morty.app.state.HomeUiState

@Composable
fun ErrorComponent(
    onRetry: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(Dimens.DIMEN_24),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(R.string.home_error_message),
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurface
        )
        Spacer(modifier = Modifier.height(Dimens.DIMEN_16))
        Button(onClick = onRetry) {
            Text(text = stringResource(R.string.home_retry))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ErrorComponentPreview() {
    RickAndMortyTheme {
        HomeComponent(
            viewState = HomeUiState.Error(
                message = "Ocurrió un error"
            )
        )
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun ErrorComponentDarkPreview() {
    RickAndMortyTheme {
        HomeComponent(
            viewState = HomeUiState.Error(
                message = "Ocurrió un error"
            )
        )
    }
}
