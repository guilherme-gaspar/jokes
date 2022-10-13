package com.guilhermegaspar.jokes.features.jokes.presentation.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import com.guilhermegaspar.jokes.features.jokes.domain.model.Joke
import kotlinx.coroutines.launch

@Composable
fun JokesList(jokes: List<Joke>) {
    LazyColumn {
        items(jokes) { joke ->
            JokeRow(joke = joke)
        }
    }
}

@Composable
// Todo: Precisa ainda implementar uma lógica que mantenha o estado único da lista, pois
// Todo: o rememberLazyListState não está funcional
fun JokesListWithScrollButton(jokes: List<Joke>) {
    Box {
        val listState = rememberLazyListState()
        val coroutineScope = rememberCoroutineScope()
        LazyColumn {
            items(jokes) { joke ->
                JokeRow(joke = joke)
            }
        }

        val showButton by remember {
            derivedStateOf {
                listState.firstVisibleItemIndex > 0
            }
        }

        AnimatedVisibility(
            visible = showButton,
            enter = fadeIn(),
            exit = fadeOut(),
        ) {
            ScrollToTopButton(onClick = {
                coroutineScope.launch {
                    listState.animateScrollToItem(0)
                }
            })
        }
    }
}