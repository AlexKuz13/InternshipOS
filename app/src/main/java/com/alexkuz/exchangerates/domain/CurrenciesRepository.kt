package com.alexkuz.exchangerates.domain

import com.alexkuz.exchangerates.model.CurrencyResponse

interface CurrenciesRepository {

    suspend fun getCurrencies(): CurrencyResponse

}