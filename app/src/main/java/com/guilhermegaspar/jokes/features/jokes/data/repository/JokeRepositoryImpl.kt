package com.guilhermegaspar.jokes.features.jokes.data.repository

import com.guilhermegaspar.jokes.features.jokes.data.remote.service.JokeService
import com.guilhermegaspar.jokes.features.jokes.domain.model.Joke
import com.guilhermegaspar.jokes.features.jokes.domain.repository.JokeRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

class JokeRepositoryImpl(private val jokeService: JokeService) : JokeRepository {
    override fun getRandomJoke(): Flow<Joke> {
        return flow {
            while (true) {
                emit(jokeService.getRandomJoke())
                delay(REFRESH_INTERVAL_MS)
            }
        }.map { response ->
            Joke(
                iconUrl = response.iconUrl,
                id = response.id,
                url = response.url,
                value = response.value
            )
        }
    }

    companion object {
        private const val REFRESH_INTERVAL_MS: Long = 1000
    }
}