package com.guilhermegaspar.jokes.features.jokes.domain.model

data class Joke(
    val iconUrl: String,
    val id: String,
    val url: String,
    val value: String
)