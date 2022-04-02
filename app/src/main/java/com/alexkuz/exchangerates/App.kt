package com.alexkuz.exchangerates

import android.app.Application
import com.alexkuz.exchangerates.di.appModule
import com.alexkuz.exchangerates.di.networkModule
import com.alexkuz.exchangerates.di.repositoryModule
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(appModule, repositoryModule, networkModule)
        }
    }
}