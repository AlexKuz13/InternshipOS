package com.alexkuz.exchangerates.data.network

import com.alexkuz.exchangerates.model.CurrencyResponse

interface CurrenciesRestRepository {

    suspend fun getCurrencies(): CurrencyResponse
}