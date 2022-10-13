package com.guilhermegaspar.jokes.stub

import com.guilhermegaspar.jokes.features.jokes.domain.model.Joke

object JokeStub {

    fun getDefaultJoke() = Joke(
        iconUrl = "TesteIconURL",
        id = "TesteID",
        url = "TesteURL",
        value = "TesteValue"
    )
}