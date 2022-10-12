package com.guilhermegaspar.jokes.features.jokes.presentation.ui.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import com.guilhermegaspar.jokes.features.jokes.presentation.viewmodel.JokeViewModel
import com.guilhermegaspar.jokes.features.jokes.presentation.ui.components.CircularProgressBar
import com.guilhermegaspar.jokes.features.jokes.presentation.ui.components.JokesList

@Composable
fun JokeScreen(viewModel: JokeViewModel) {
    val state = viewModel.state.collectAsState()

    if (state.value.isLoading) {
        CircularProgressBar()
    } else {
        JokesList(state.value.joke)
    }
}
