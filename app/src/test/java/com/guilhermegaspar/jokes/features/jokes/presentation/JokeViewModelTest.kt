package com.guilhermegaspar.jokes.features.jokes.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import app.cash.turbine.test
import com.guilhermegaspar.jokes.common.MainDispatcherRule
import com.guilhermegaspar.jokes.features.jokes.domain.model.Joke
import com.guilhermegaspar.jokes.features.jokes.domain.usecase.GetRandomJokeUseCase
import io.mockk.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.*
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class JokeViewModelTest {

    private lateinit var jokeViewModel: JokeViewModel
    private val getRandomJokeUseCase: GetRandomJokeUseCase = mockk()

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    @get:Rule
    val localTestRule = InstantTaskExecutorRule()

    @Before
    fun setup() {
        createViewModel()
    }

    private fun createViewModel() {
        jokeViewModel = JokeViewModel(getRandomJokeUseCase = getRandomJokeUseCase)
    }

    @Test
    fun `getRandomJoke should get random joke`() = runTest {
        // Given
        val joke = Joke("Teste", "teste", "teste", "teste")

        every { getRandomJokeUseCase() } returns flow { emit(joke) }

        // When
        jokeViewModel.getRandomJoke()
        advanceUntilIdle()

        // Then
        jokeViewModel.state.test {
            val item = awaitItem().joke.first()
            assertEquals(joke, item)
        }
    }

    @Test
    fun `init should have the correct state`() {
        // Given
        val initialState = JokeState()
        val currentState = jokeViewModel.state.value

        // When
        createViewModel()

        // Then
        assertEquals(currentState, initialState)
    }
}


