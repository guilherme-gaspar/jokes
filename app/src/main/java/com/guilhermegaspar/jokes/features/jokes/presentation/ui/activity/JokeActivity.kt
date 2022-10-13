package com.guilhermegaspar.jokes.features.jokes.presentation.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import com.guilhermegaspar.jokes.common.extension.setImageFromUrl
import com.guilhermegaspar.jokes.common.utils.getRandomResourceColor
import com.guilhermegaspar.jokes.databinding.ActivityJokeBinding
import com.guilhermegaspar.jokes.features.jokes.domain.model.Joke
import com.guilhermegaspar.jokes.features.jokes.presentation.model.JokeState
import com.guilhermegaspar.jokes.features.jokes.presentation.viewmodel.JokeViewModel
import kotlinx.coroutines.flow.collectLatest
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
        lifecycleScope.launchWhenResumed {
            viewModel.state.collectLatest { state ->
                setupUi(state)
            }
        }
    }

    private fun setupUi(state: JokeState) {
        showLoading(state.isLoading)
        state.joke.forEach { joke ->
            showContainer(joke)
        }
    }

    private fun showContainer(joke: Joke) {
        val resourceColor = getRandomResourceColor()
        binding.mainContainer.setBackgroundResource(resourceColor)
        binding.textViewJoke.text = joke.value
        // URL da API não está funcional, por isso no parâmetro
        binding.imageViewJoke.setImageFromUrl(url = null, context = this)
    }

    private fun showLoading(loading: Boolean) {
        binding.progressBar.isVisible = loading
        binding.cardViewMain.isVisible = !loading
    }
}