package com.yeison.rick_and_morty.app.ui.component

import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.yeison.core.theme.RickAndMortyTheme
import com.yeison.core.utils.Dimens

@Composable
fun LoadingDialogComponent() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(
            modifier = Modifier.size(Dimens.DIMEN_50),
            color = Color.Green
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LoadingDialogComponentPreview() {
    RickAndMortyTheme {
        LoadingDialogComponent()
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun LoadingDialogComponentDarkPreview() {
    RickAndMortyTheme {
        LoadingDialogComponent()
    }
}