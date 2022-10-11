package com.guilhermegaspar.jokes.core

import android.app.Application
import com.guilhermegaspar.jokes.di.KoinManager
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class JokesApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@JokesApp)
            modules(KoinManager.loadAllModules())
        }
    }
}