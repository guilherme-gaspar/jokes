package com.guilhermegaspar.jokes.features.jokes.presentation.ui.screen

import androidx.compose.runtime.*
import com.guilhermegaspar.jokes.features.jokes.presentation.viewmodel.JokeViewModel
import com.guilhermegaspar.jokes.features.jokes.presentation.ui.components.CircularProgressBar
import com.guilhermegaspar.jokes.features.jokes.presentation.ui.components.ErrorDialog
import com.guilhermegaspar.jokes.features.jokes.presentation.ui.components.JokesList

@Composable
fun JokeScreen(viewModel: JokeViewModel) {
    val state = viewModel.state.collectAsState()
    val showError = remember {
        mutableStateOf(true)
    }
    if (state.value.isLoading) {
        CircularProgressBar()
    } else {
        // Todo: melhorar gerenciador de erro
        state.value.error?.let {
            showError.value = true
            if (showError.value) {
                ErrorDialog(errorMessage = it, onDismiss = {
                    showError.value = false
                }, onTryAgain = {
                    viewModel.getRandomJoke()
                    showError.value = false
                })
            }
        }
        JokesList(state.value.joke)
    }
}
