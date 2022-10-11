package com.guilhermegaspar.jokes.features.jokes.data.datasource

import com.guilhermegaspar.jokes.features.jokes.data.remote.model.JokeResponse
import kotlinx.coroutines.flow.Flow

interface JokeRemoteDataSource {

    fun getRandomJoke(): Flow<JokeResponse>
}