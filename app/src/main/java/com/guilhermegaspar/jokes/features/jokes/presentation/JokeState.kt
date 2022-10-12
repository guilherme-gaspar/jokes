package com.guilhermegaspar.jokes.features.jokes.presentation

import com.guilhermegaspar.jokes.features.jokes.domain.model.Joke

data class JokeState(
    val isLoading: Boolean = false,
    val joke: List<Joke> = emptyList()
)