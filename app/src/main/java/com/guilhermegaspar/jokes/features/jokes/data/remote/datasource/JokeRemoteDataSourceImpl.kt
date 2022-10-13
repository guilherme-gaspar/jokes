package com.guilhermegaspar.jokes.features.jokes.data.remote.datasource

import com.guilhermegaspar.jokes.features.jokes.data.datasource.JokeRemoteDataSource
import com.guilhermegaspar.jokes.features.jokes.data.remote.model.JokeResponse
import com.guilhermegaspar.jokes.features.jokes.data.remote.service.JokeService
import com.guilhermegaspar.jokes.network.utils.parseHttpError
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class JokeRemoteDataSourceImpl(private val jokeService: JokeService) : JokeRemoteDataSource {

    override fun getRandomJoke(): Flow<JokeResponse> {
        return flow {
            while (true) {
                emit(jokeService.getRandomJoke())
                delay(REFRESH_INTERVAL_MS)
            }
        }.parseHttpError()
    }

    companion object {
        private const val REFRESH_INTERVAL_MS: Long = 1000
    }
}