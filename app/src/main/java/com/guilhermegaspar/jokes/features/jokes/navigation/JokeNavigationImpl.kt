package com.guilhermegaspar.jokes.features.jokes.navigation

import android.content.Context
import android.content.Intent
import com.guilhermegaspar.jokes.features.jokes.presentation.JokeActivity
import com.guilhermegaspar.jokes.navigation.jokes.JokeNavigation

class JokeNavigationImpl() : JokeNavigation {
    override fun navigateToJokes(context: Context) {
        context.startActivity(Intent(context, JokeActivity::class.java))
    }
}