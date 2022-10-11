package com.guilhermegaspar.jokes.features.jokes.di

import com.guilhermegaspar.jokes.features.jokes.data.remote.service.JokeService
import com.guilhermegaspar.jokes.features.jokes.data.repository.JokeRepositoryImpl
import com.guilhermegaspar.jokes.features.jokes.domain.usecase.GetRandomJokeUseCase
import com.guilhermegaspar.jokes.features.jokes.navigation.JokeNavigationImpl
import com.guilhermegaspar.jokes.features.jokes.presentation.JokeViewModel
import com.guilhermegaspar.jokes.navigation.jokes.JokeNavigation
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

fun getJokeModule() = module {
    factory<JokeNavigation> { JokeNavigationImpl() }

    viewModel {
        JokeViewModel(
            getRandomJokeUseCase = GetRandomJokeUseCase(
                JokeRepositoryImpl(
                    jokeService = get<Retrofit>().create(JokeService::class.java)
                )
            )
        )
    }
}