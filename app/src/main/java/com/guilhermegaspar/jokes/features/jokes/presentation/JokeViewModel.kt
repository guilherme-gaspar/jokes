package com.guilhermegaspar.jokes.features.jokes.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.guilhermegaspar.jokes.features.jokes.domain.model.Joke
import com.guilhermegaspar.jokes.features.jokes.domain.usecase.GetRandomJokeUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class JokeViewModel(private val getRandomJokeUseCase: GetRandomJokeUseCase) : ViewModel() {

    private val _joke: MutableLiveData<JokeState> = MutableLiveData(JokeState())
    val joke: LiveData<JokeState> = _joke

    init {
        getRandomJoke()
    }

    fun getRandomJoke() {
        viewModelScope.launch {
            getRandomJokeUseCase().onStart {
                _joke.value = _joke.value?.copy(isLoading = true)
            }.catch {
                Log.i("JokeApplication", "CatchFlow: ${it.message}")
            }.onCompletion {
                Log.i("JokeApplication", "OnCompletion")
                _joke.value = _joke.value?.copy(isLoading = false)
            }.collect {
                Log.i("JokeApplication", "ColletFlow")
                _joke.value = _joke.value?.copy(joke = it, isLoading = false)
            }
        }
    }
}