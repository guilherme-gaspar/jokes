package com.guilhermegaspar.jokes.features.jokes.presentation.ui.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.guilhermegaspar.jokes.features.jokes.domain.model.Joke

@Composable
fun JokesList(jokes: List<Joke>) {
    LazyColumn {
        items(jokes) { joke ->
            JokeRow(joke = joke)
        }
    }
}