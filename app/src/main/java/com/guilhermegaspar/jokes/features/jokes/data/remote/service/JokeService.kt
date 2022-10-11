package com.guilhermegaspar.jokes.features.jokes.data.remote.service

import com.guilhermegaspar.jokes.features.jokes.data.remote.model.JokeResponse
import retrofit2.http.GET

interface JokeService {

    @GET("jokes/random")
    suspend fun getRandomJoke(): JokeResponse
}