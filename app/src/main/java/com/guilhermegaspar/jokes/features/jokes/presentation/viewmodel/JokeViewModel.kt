package com.guilhermegaspar.jokes.features.jokes.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.guilhermegaspar.jokes.features.jokes.domain.model.Joke
import com.guilhermegaspar.jokes.features.jokes.domain.usecase.GetRandomJokeUseCase
import com.guilhermegaspar.jokes.features.jokes.presentation.model.JokeState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class JokeViewModel(private val getRandomJokeUseCase: GetRandomJokeUseCase) : ViewModel() {

    private val _state: MutableStateFlow<JokeState> = MutableStateFlow(JokeState())
    val state: StateFlow<JokeState> = _state

    init {
        getRandomJoke()
    }

    fun getRandomJoke() {
        viewModelScope.launch {
            getRandomJokeUseCase().onStart {
                _state.value = _state.value.copy(isLoading = true)
                delay(2000)
            }.catch {
                Log.i("JokeApplication", "CatchFlow: ${it.message}")
            }.onCompletion {
                _state.value = _state.value.copy(isLoading = false)
            }.collect {
                _state.value = JokeState(joke = mutableListOf<Joke>().apply {
                    addAll(_state.value.joke)
                    add(it)
                })
            }
        }
    }
}