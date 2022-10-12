package com.guilhermegaspar.jokes.features.jokes.presentation.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun CircularProgressBar(
    contentAlignment: Alignment = Alignment.Center,
    modifier: Modifier = Modifier.fillMaxSize()
) {
    Box(contentAlignment = contentAlignment, modifier = modifier) {
        CircularProgressIndicator(
            color = Color.Black,
        )
    }
}