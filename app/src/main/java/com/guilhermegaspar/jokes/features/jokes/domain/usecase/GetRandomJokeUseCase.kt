package com.guilhermegaspar.jokes.features.jokes.domain.usecase

import com.guilhermegaspar.jokes.features.jokes.domain.model.Joke
import com.guilhermegaspar.jokes.features.jokes.domain.repository.JokeRepository
import kotlinx.coroutines.flow.Flow

class GetRandomJokeUseCase(private val repository: JokeRepository) {
    operator fun invoke(): Flow<Joke> {
        return repository.getRandomJoke()
    }
}