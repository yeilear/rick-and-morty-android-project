package com.yeison.rick_and_morty.ui.component

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.yeison.core.extensions.ONE
import com.yeison.core.extensions.ZERO
import com.yeison.core.theme.RickAndMortyTheme
import com.yeison.core.utils.Dimens.DIMEN_16
import com.yeison.core.utils.Dimens.DIMEN_3
import com.yeison.core.utils.Dimens.DIMEN_32
import com.yeison.core.R as core

private const val DURATION_ANIMATION_MILLIS = 800

@Composable
fun SplashComponent(
    onTimeout: () -> Unit
) {
    val scale = remember { Animatable(Float.ZERO) }

    LaunchedEffect(Unit) {
        scale.animateTo(
            targetValue = Float.ONE,
            animationSpec = tween(DURATION_ANIMATION_MILLIS, easing = FastOutSlowInEasing)
        )
        onTimeout()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(core.color.black)),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .scale(scale.value),
                painter = painterResource(id = core.drawable.splash),
                contentDescription = null
            )

            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(DIMEN_32)
                    .scale(scale.value),
                painter = painterResource(id = core.drawable.splash_title),
                contentDescription = null
            )
        }

        CircularProgressIndicator(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .safeDrawingPadding()
                .padding(DIMEN_16)
                .size(DIMEN_32),
            color = Color.Green,
            strokeWidth = DIMEN_3
        )
    }
}

@Preview
@Composable
fun SplashComponentPreview(){
    RickAndMortyTheme {
        SplashComponent(
            onTimeout = { 
                // Do nothing
            }
        )
    }
}