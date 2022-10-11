package com.guilhermegaspar.jokes.features.jokes.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.guilhermegaspar.jokes.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class JokeActivity : AppCompatActivity() {

    private val viewModel: JokeViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_joke)

        viewModel.joke.observe(this) {
            findViewById<TextView>(R.id.textView).text = it.value
        }
    }
}