package com.guilhermegaspar.jokes.features.jokes.domain.repository

import com.guilhermegaspar.jokes.features.jokes.domain.model.Joke
import kotlinx.coroutines.flow.Flow

interface JokeRepository {

    fun getRandomJoke(): Flow<Joke>
}