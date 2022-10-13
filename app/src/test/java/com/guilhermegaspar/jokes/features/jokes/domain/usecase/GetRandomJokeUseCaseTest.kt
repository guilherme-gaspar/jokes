package com.guilhermegaspar.jokes.features.jokes.domain.usecase

import app.cash.turbine.test
import com.guilhermegaspar.jokes.features.jokes.domain.model.Joke
import com.guilhermegaspar.jokes.features.jokes.domain.repository.JokeRepository
import com.guilhermegaspar.jokes.stub.JokeStub
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test

class GetRandomJokeUseCaseTest {

    private val repository: JokeRepository = mockk()
    private val getRandomJokeUseCase = GetRandomJokeUseCase(repository = repository)

    @Test
    fun `getRandomJokeUseCase should return a Joke when success`() = runBlocking {
        // Given
        val joke = JokeStub.getDefaultJoke()
        every { getRandomJokeUseCase() } returns flow { emit(joke) }

        // When
        val result = getRandomJokeUseCase()

        // Then
        result.test {
            assertEquals(joke, awaitItem())
            awaitComplete()
        }
    }

    @Test
    fun `getRandomJokeUseCase should return a Exception when error`() = runBlocking {
        // Given
        val exception = Exception("Erro ao consultar")
        every { getRandomJokeUseCase() } returns flow { throw exception }

        // When
        val result = getRandomJokeUseCase()

        // Then
        result.test {
            assertEquals(exception.message, awaitError().message)
        }
    }
}