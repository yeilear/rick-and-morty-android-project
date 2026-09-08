package com.yeison.rick_and_morty.app.ui.component

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import com.yeison.core.extensions.ONE
import com.yeison.core.extensions.TWO
import com.yeison.core.theme.RickAndMortyTheme
import com.yeison.core.utils.Dimens
import com.yeison.core.utils.Dimens.DIMEN_8
import com.yeison.core.utils.Dimens.DIMEN_80
import com.yeison.home.R
import com.yeison.rick_and_morty.app.state.HomeUiState
import com.yeison.rick_and_morty.app.ui.model.CharacterStatus
import com.yeison.rick_and_morty.domain.model.ResultsEntity
import com.yeison.core.R as core

@Composable
fun HomeComponent(
    viewState: HomeUiState,
    onRetry: () -> Unit = {}
) {
    when (viewState) {
        HomeUiState.Loading -> LoadingDialogComponent()
        is HomeUiState.Error -> ErrorComponent(viewState.message, onRetry = onRetry)
        is HomeUiState.Success -> CharacterList(characters = viewState.characters)
    }
}

@Composable
private fun CharacterList(characters: List<ResultsEntity>) {
    if (characters.isEmpty()) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = stringResource(R.string.home_empty),
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurface
            )
        }
    } else {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .systemBarsPadding(),
            contentPadding = PaddingValues(Dimens.DIMEN_16),
            verticalArrangement = Arrangement.spacedBy(Dimens.DIMEN_12)
        ) {
            item {
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .heightIn(max = DIMEN_80),
                    painter = painterResource(id = core.drawable.splash_title),
                    contentDescription = null
                )
            }
            item {
                Spacer(modifier = Modifier.width(Dimens.DIMEN_16))
            }
            item {
                Text(
                    text = stringResource(R.string.home_title),
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier.padding(bottom = DIMEN_8)
                )
            }
            item {
                Spacer(modifier = Modifier.width(Dimens.DIMEN_16))
            }
            items(characters, key = { it.id }) { character ->
                CharacterCard(character = character)
            }
        }
    }
}

@Composable
private fun CharacterCard(character: ResultsEntity) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(Dimens.DIMEN_12),
        color = MaterialTheme.colorScheme.surfaceVariant
    ) {
        Row(
            modifier = Modifier.padding(Dimens.DIMEN_12),
            verticalAlignment = Alignment.CenterVertically
        ) {

            AsyncImage(
                model = character.image,
                contentDescription = character.name,
                modifier = Modifier
                    .size(Dimens.DIMEN_80)
                    .clip(RoundedCornerShape(DIMEN_8)),
                contentScale = ContentScale.Crop,
                placeholder = ColorPainter(MaterialTheme.colorScheme.surface),
                error = ColorPainter(MaterialTheme.colorScheme.surface)
            )

            Spacer(modifier = Modifier.width(Dimens.DIMEN_16))

            Column(
                modifier = Modifier.weight(Float.ONE)
            ) {
                Text(
                    text = character.name,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    maxLines = Int.TWO,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(Dimens.DIMEN_4))

                StatusLabel(characterStatus = character.status)
            }
        }
    }
}

@Composable
private fun StatusLabel(characterStatus: CharacterStatus) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Box(
            modifier = Modifier
                .size(DIMEN_8)
                .clip(CircleShape)
                .background(characterStatus.color)
        )
        Spacer(modifier = Modifier.width(DIMEN_8))
        Text(
            text = characterStatus.status.replaceFirstChar { it.uppercase() },
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurface
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HomeComponentPreview() {
    RickAndMortyTheme {
        HomeComponent(
            viewState = HomeUiState.Success(
                characters = listOf(
                    ResultsEntity(
                        id = 1,
                        name = "Rick Sanchez",
                        status = CharacterStatus.ALIVE,
                        image = "https://rickandmortyapi.com/api/character/avatar/1.jpeg"
                    )
                )
            )
        )
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun HomeComponentDarkPreview() {
    RickAndMortyTheme {
        HomeComponent(
            viewState = HomeUiState.Success(
                characters = listOf(
                    ResultsEntity(
                        id = 1,
                        name = "Rick Sanchez",
                        status = CharacterStatus.ALIVE,
                        image = "https://rickandmortyapi.com/api/character/avatar/1.jpeg"
                    )
                )
            )
        )
    }
}