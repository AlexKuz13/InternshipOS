package com.alexkuz.exchangerates.di

import com.alexkuz.exchangerates.data.network.CurrenciesRestRepository
import com.alexkuz.exchangerates.data.network.CurrenciesRestRepositoryImpl
import com.alexkuz.exchangerates.domain.CurrenciesRepository
import com.alexkuz.exchangerates.domain.CurrenciesRepositoryImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val repositoryModule = module {

    single<CurrenciesRestRepository> {
        CurrenciesRestRepositoryImpl(
            currencyApi = get()
        )
    }

    single<CurrenciesRepository> {
        CurrenciesRepositoryImpl(
            restRepository = get(),
            context = androidContext()
        )
    }

}
