package com.guilhermegaspar.jokes.di

import com.guilhermegaspar.jokes.features.jokes.di.getJokeModule
import com.guilhermegaspar.jokes.network.di.getNetworkModule
import org.koin.core.module.Module

object KoinManager {
    fun loadAllModules(): List<Module> {
        return listOf(
            getNetworkModule(), getJokeModule()
        )
    }
}