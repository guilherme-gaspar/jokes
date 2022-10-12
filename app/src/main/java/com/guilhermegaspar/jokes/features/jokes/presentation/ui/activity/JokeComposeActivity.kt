package com.guilhermegaspar.jokes.features.jokes.presentation.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.guilhermegaspar.jokes.features.jokes.presentation.viewmodel.JokeViewModel
import com.guilhermegaspar.jokes.features.jokes.presentation.ui.screen.JokeScreen
import com.guilhermegaspar.jokes.features.jokes.presentation.ui.theme.JokesTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class JokeComposeActivity : ComponentActivity() {

    private val viewModel: JokeViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JokesTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    JokeScreen(viewModel = viewModel)
                }
            }
        }
    }
}