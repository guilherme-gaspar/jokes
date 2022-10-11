package com.guilhermegaspar.jokes.features.jokes.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.guilhermegaspar.jokes.common.getRandomResourceColor
import com.guilhermegaspar.jokes.common.setImageFromUrl
import com.guilhermegaspar.jokes.databinding.ActivityJokeBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class JokeActivity : AppCompatActivity() {

    private val viewModel: JokeViewModel by viewModel()
    private lateinit var binding: ActivityJokeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJokeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupObserver()
    }

    private fun setupObserver() {
        viewModel.joke.observe(this) {
            if (it.isLoading) {
                binding.progressBar.visibility = View.VISIBLE
                binding.cardViewMain.visibility = View.GONE
            } else {
                val resourceColor = getRandomResourceColor()
                binding.cardViewMain.visibility = View.VISIBLE
                binding.mainContainer.setBackgroundResource(resourceColor)
                binding.textViewJoke.text = it.joke?.value
                binding.imageViewJoke.setImageFromUrl(it.joke?.iconUrl, this)
            }

        }
    }
}