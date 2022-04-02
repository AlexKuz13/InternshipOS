package com.alexkuz.exchangerates.data.network

import com.alexkuz.exchangerates.model.CurrencyResult

interface CurrenciesRestRepository {

    suspend fun getCurrencies(): CurrencyResult
}