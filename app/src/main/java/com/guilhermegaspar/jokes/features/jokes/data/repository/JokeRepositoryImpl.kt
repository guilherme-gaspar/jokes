package com.guilhermegaspar.jokes.features.jokes.data.repository

import com.guilhermegaspar.jokes.features.jokes.data.datasource.JokeRemoteDataSource
import com.guilhermegaspar.jokes.features.jokes.domain.model.Joke
import com.guilhermegaspar.jokes.features.jokes.domain.repository.JokeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class JokeRepositoryImpl(private val remoteDataSource: JokeRemoteDataSource) : JokeRepository {
    override fun getRandomJoke(): Flow<Joke> {
        return remoteDataSource.getRandomJoke().map { response ->
            Joke(
                iconUrl = response.iconUrl,
                id = response.id,
                url = response.url,
                value = response.value
            )
        }
    }
}