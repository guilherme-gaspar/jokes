package com.guilhermegaspar.jokes.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.guilhermegaspar.jokes.R
import com.guilhermegaspar.jokes.navigation.jokes.JokeNavigation
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private val jokeNavigation: JokeNavigation by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        jokeNavigation.navigateToJokes(this)
    }
}