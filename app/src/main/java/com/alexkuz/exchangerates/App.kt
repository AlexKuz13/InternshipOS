package com.alexkuz.exchangerates

import android.app.Application
import com.alexkuz.exchangerates.di.appModule
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(appModule)
        }
    }
}