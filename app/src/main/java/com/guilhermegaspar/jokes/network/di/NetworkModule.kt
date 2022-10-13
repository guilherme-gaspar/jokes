package com.guilhermegaspar.jokes.network.di

import com.guilhermegaspar.jokes.network.config.RetrofitConfig
import org.koin.dsl.module

fun getNetworkModule() = module {
    single { RetrofitConfig.getInstance() }
}