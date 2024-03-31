package com.androiddev.koindependenciessample

import android.app.Application
import com.androiddev.koindependenciessample.di.interactionModule
import com.androiddev.koindependenciessample.di.networkModule
import com.androiddev.koindependenciessample.di.presentationModule
import com.androiddev.koindependenciessample.di.repositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            // Log Koin into Android logger
            androidLogger()
            // Reference Android context
            androidContext(this@MainApplication)
            //Load Modules
            modules(interactionModule, networkModule, presentationModule, repositoryModule)
        }
    }
}