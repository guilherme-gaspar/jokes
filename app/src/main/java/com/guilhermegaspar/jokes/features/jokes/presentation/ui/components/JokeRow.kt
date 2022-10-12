package com.guilhermegaspar.jokes.features.jokes.presentation.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.guilhermegaspar.jokes.features.jokes.domain.model.Joke

@Composable
fun JokeRow(joke: Joke) {
    Box(modifier = Modifier.padding(28.dp)) {
        Card(shape = RoundedCornerShape(8.dp), backgroundColor = MaterialTheme.colors.surface) {
            Column(
                modifier = Modifier
                    .height(200.dp)
                    .padding(16.dp)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = joke.value, style = MaterialTheme.typography.h6)
            }
        }
    }
}