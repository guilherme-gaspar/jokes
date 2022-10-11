package com.guilhermegaspar.jokes.features.jokes.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import com.guilhermegaspar.jokes.common.extension.getRandomResourceColor
import com.guilhermegaspar.jokes.common.extension.setImageFromUrl
import com.guilhermegaspar.jokes.databinding.ActivityJokeBinding
import com.guilhermegaspar.jokes.features.jokes.domain.model.Joke
import org.koin.androidx.viewmodel.ext.android.viewModel

class JokeActivity : AppCompatActivity() {

    private val viewModel: JokeViewModel by viewModel()
    private lateinit var binding: ActivityJokeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupScreen()
        setupObserver()
    }

    private fun setupScreen() {
        binding = ActivityJokeBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun setupObserver() {
        viewModel.state.observe(this) { state ->
            setupUi(state)
        }
    }

    private fun setupUi(state: JokeState) {
        showLoading(state.isLoading)
        state.joke?.let { joke ->
            showContainer(joke)
        }
    }

    private fun showContainer(joke: Joke) {
        val resourceColor = getRandomResourceColor()
        binding.mainContainer.setBackgroundResource(resourceColor)
        binding.textViewJoke.text = joke.value
        binding.imageViewJoke.setImageFromUrl(joke.iconUrl, context = this)
    }

    private fun showLoading(loading: Boolean) {
        binding.progressBar.isVisible = loading
        binding.cardViewMain.isVisible = !loading
    }
}